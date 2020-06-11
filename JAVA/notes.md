# IO主要内容
## java.io.File类
通过程序把一个图放到一个文件夹，把图片转化为一个数据集（例如二进制），这些数据一点一点传到文件夹，这个传递过程很类似于水的流动。File类只能操作文件本身但是不能操作文件内容。<br>

**文件流（基于文件）：** FIleInputStream/FileOutputStream/FileReader/FileWriter <br>
**缓冲流（基于内存）：** BufferedInputStream/BufferedOutputStream/BufferedReader/BufferedWriter <br>

```
File f = new File("/Users/chuzhengtian/Desktop/hello.txt");     //定义一个file对象
```
|文件名方法|用处|文件检测方法|用处|获取常规文件信息方法|用处|文件操作方法|用处|目录相关操作|用处|
|:---:|:---:|:---:|:---:|:---:|:----:|:---:|:----:|:----:|:----:|
|getName()|获取文件名|exists()|是否存在|length()|文件长度|createNewFile()|创建文件夹|mkdir()|创建单层目录|
|getPath()|newfile中的路径|canWrite()|是否可读|lastModify()|上次修改时间|delete()|删除文件|mkdirs()|创建多层目录|
|getAbsolutePath()|绝对路径|canRead()|是否可写|||||list()|文件夹清单|
|getParent()|获取父级文件夹|isFile()|是否是文件|
|renameTo(File newname)|改名|isDirectory()|是否是文件夹|

### 字节输入流
 ```
 try{
   FileInputStream in = new FileInputStream("/Users/chuzhengtian/Desktop/hello.txt");
   byte[] b = new byte[10];
   len = 0;
   while((len = in.read(b)) != -1){     // read()返回读入缓冲区的总字节数；如果因为已经到达流末尾而不再有数据可用，则返回 -1。
      System.out.println(new String(b,0,len)); //b：读入数据到缓存区；off：初始偏移量；len：要读取的最大字节数
   }
   in.close();
 }catch(Exception e){
   e.printStackTrace();
 }
 ```
 
 ### 字节输出流
 ```
 try{
   FileOutputStream out = new FileOutputStream(""/Users/chuzhengtian/Desktop/hello2.txt"");
   String str = "kgkekdkgvjlw";
   out.write(str.getBytes());  //写到内存
   out.flush(); //把内存中的数据写到硬盘
   out.close();
 catch(Exception e){
   e.printStackTrace();
 }
 
 ```
