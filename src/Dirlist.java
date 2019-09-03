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
        File path = new File("E:/Algorithm/src/test.txt");
        try{

//            FileReader fileReader = new FileReader(path);
//            int data = fileReader.read();
//            while(data != -1) {
//                System.out.println((char)data);
//                data = fileReader.read();
//            }
            OutputStream outputStream = new FileOutputStream(path);
            outputStream.write("hellowoafarld".getBytes());
            outputStream.close();


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
