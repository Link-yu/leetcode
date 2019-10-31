### 用法

在springbootApplication启动类中加入@EnableScheduling 注解
```markdown
@Component
public class UpdateTimer {
    private Logger logger = LoggerFactory.getLogger(UpdateTimer.class);
    private int fixeDelayNum = 0;
    private int fixedRateNum = 0;
    @Scheduled(fixedDelay = 5000)
    public void testFixedDalay() {
        try{
            logger.info("testFixedDalay 第 {} 次", fixeDelayNum++);
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }

    //fixedRate 是有一个时刻表的概念，在任务启动时，T1、T2、T3就已经排好了执行的时刻，比如1分、2分、3分，当T1的执行时间大于1分钟时，就会造成T2晚点，当T1执行完时T2立即执行
    @Scheduled(fixedRate = 5000)
    public void testFixedRate() {
        try{
            logger.info("testFixedRate 第 {} 次", fixedRateNum++);
            Thread.sleep(6000);
        } catch (Exception e) {

        }
    }

}
```

如果需要多线程执行任务
```markdown
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
    }
}
```

### Corn表达式
spring的schedule值支持6个域的表达式,（秒 分 时 每月第几天 月 星期）