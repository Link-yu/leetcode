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
true表示追加
false表示覆盖
            OutputStream outputStream = new FileOutputStream(path,true);
            outputStream.write("Hello World".getBytes());
            outputStream.close();
```
flush()

当你往FileOutputStream里写数据的时候，这些数据有可能会缓存在内存中。在之后的某个时间，比如，每次都只有X份数据可写，或者FileOutputStream关闭的时候，才会真正地写入磁盘。当FileOutputStream没被关闭，而你又想确保写入到FileOutputStream中的数据写入到磁盘中，可以调用flush()方法，该方法可以保证所有写入到FileOutputStream的数据全部写入到磁盘中。

#### RandomAccessFile
RandomAccessFile允许你来回读写文件，也可以替换文件中的某些部分。


#### BufferedInputStream
BufferedInputStream能为输入流提供缓冲区，能提高很多IO的速度。你可以一次读取一大块的数据，而不需要每次从网络或者磁盘中一次读取一个字节。特别是在访问大量磁盘数据时，缓冲通常会让IO快上许多。
把输入流包装到BufferedInputStream中。
```$xslt
InputStream input = new BufferedInputStream(new FileInputStream("c:\\data\\input-file.txt"));
```


#### DataInputStream
DataInputStream可以使你从输入流中读取Java基本类型数据，而不必每次读取字节数据。你可以把InputStream包装到DataInputStream中，然后就可以从此输入流中读取基本类型数据了，

#### InputStreamReader
字节流转换成字符流。
```$xslt
InputStream inputStream = new FileInputStream("c:\\data\\input.txt");
Reader reader = new InputStreamReader(inputStream);

此时该InputStreamReader会将输入的字节流转换成UTF8字符流。
Reader reader = new InputStreamReader(inputStream, "UTF-8");
```


#### BufferedReader
BufferedReader能为字符输入流提供缓冲区，可以提高许多IO处理的速度。你可以一次读取一大块的数据，而不需要每次从网络或者磁盘中一次读取一个字节。特别是在访问大量磁盘数据时，缓冲通常会让IO快上许多。
BufferedReader和BufferedInputStream的主要区别在于，BufferedReader操作字符，而BufferedInputStream操作原始字节。只需要把Reader包装到BufferedReader中，就可以为Reader添加缓冲区(译者注：默认缓冲区大小为8192字节，即8KB)。


https://www.zhihu.com/question/29005375