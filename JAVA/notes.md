
# 变量
### 实例变量
在类中定义（方法外），在类初始化时初始化，不同实例中有不同的值。

### 类变量
在类中定义（方法外），在类初始化时初始化，类的变量。

### 本地变量
在方法，构造器或者语句块中定义，当我们退出方法时被摧毁。


# static
### 静态变量
在类的任何对象存在之前访问，用dot
### 静态方法
只能调用其他静态方法，只能访问静态数据，访问时类名后面加dot
### 静态类
最外层的类不能设置为静态，最内层的类可以设置。静态嵌套类只能访问外部类的静态成员。

# 数据类型
### 原始数据类型
#### 整数类型
**byte** （8bit，范围-128～127）,**short** （2字节，范围-2^15～2^15-1）,**int** （4字节，范围-2^31～2^31-1）,**long** (8字节，范围-2^ 63～2^63-1)
#### 浮点类型
**float**（4字节，范围-2^128~2^128，7位有效数字）,**double**（8字节，范围-2^1024~2^1024,16位有效数字）

#### 布尔类型
**boolean**：true/false
#### 字符类型
**char** ：单引号扩起来的单个字母数字符号


### 引用数据类型
class,interface,list


# 访问修饰符
|修饰符|当前类|同一包内|子孙类|外部包|
|:---:|:--:|:---:|:----:|:---:|
|public|y|y|y|y|
|protected|y|y|y|n|
|default|y|y|n|n|
|private|y|n|n|n|

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
