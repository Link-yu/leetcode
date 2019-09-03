import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created on 2017/7/17.
 * Title: Simple
 * Description: Example
 * Copyright: Copyright(c) 2016
 * Company: 杭州公共交通云科技有限公司
 *
 * @author 维斯
 */
public class Dirlist {
    public static void main(String[] args) {
        Dirlist dirlist = new Dirlist();
        File in = new File("E:/Algorithm/src/file.pdf");
        File out = new File("E:/Algorithm/src/test.txt");
        try{
            long time = dirlist.transferFile(in, out);
            System.out.println(time);
//            InputStream inputStream = new FileInputStream(path);
//            Reader reader = new FileReader(path);
//            int data = reader.read();
//            while(data != -1) {
//                System.out.println(data);
//                System.out.println((char) data);
//                data = reader.read();
//            }
//            FileReader fileReader = new FileReader(path);
//            int data = fileReader.read();
//            while(data != -1) {
//                System.out.println((char)data);
//                data = fileReader.read();
//            }



//            String[] list;
//            if (args.length == 0) {
//                list = path.list();
//            } else {
//                list = path.list(new DirFilter("java"));
//
//            }
//            Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
//            for (String str:list) {
//                System.out.println(str);
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public long transferFile(File in, File out) throws IOException{
        long start = System.currentTimeMillis();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(in));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(out));

        byte[] bytes = new byte[1024*1024];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes,0,len);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }
}

class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
