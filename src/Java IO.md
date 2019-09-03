### 流
Java IO流是既可以从中读取，也可以写入到其中的**数据流**。

流和数组不一样，无法通过下标索引来读写数据，也不能像数组一样前后移动读写数据，流仅仅是一个连续的数据。

流分为字节流和字符流。字节流：InputStream和OutputStream。字符流：Reader和Writer。

#### InputStream
java.io.InputStream是所有字节流的基类，开发时建议用InputStream替代它的任何子类。
```
            File path = new File("E:/Algorithm/src/Solution.java");
            InputStream fileInputStream = new FileInputStream(path);
//            int data = fileInputStream.read();
//            while(data != -1) {
//                System.out.println(data);
//                data = fileInputStream.read();
//            }
            while(fileInputStream.available() >0 ) {
                System.out.println(fileInputStream.read());
            }
```
如上代码所示，通常使用read()读取数据。read()返回一个整数，代表读取到的内容。当达到末尾，read()返回-1。
available()返回还剩可以读取的字节数目。

#### OutputStream
```$xslt
            OutputStream outputStream = new FileOutputStream(path);
            outputStream.write("Hello World".getBytes());
            outputStream.close();
```

