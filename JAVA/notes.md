
# 变量
### 实例变量
在类中定义（方法外），在类初始化时初始化，不同实例中有不同的值。

### 类变量
在类中定义（方法外），在类初始化时初始化，类的变量。

### 本地变量
在方法，构造器或者语句块中定义，当我们退出方法时被摧毁。


# static
用于减少JVM的使用，让代码更加安全，可以节约大量的内存。
### 静态变量
在类的任何对象存在之前访问，用dot
### 静态方法
只能调用其他静态方法，只能访问静态数据，访问时类名后面加dot
### 静态类
最外层的类不能设置为静态，最内层的类可以设置。静态嵌套类只能访问外部类的静态成员。

# 数据类型
原始类型和引用类型都使用按值传递，参数值被复制到方法的参数中，如果复制的参数是原始类型，更改不会影响原始参数；如果是引用类型，更改会影响对象，因为对对象的引用是复制的。

# 面向对象编程
允许多个开发人员更有效的处理同一个项目。
## Inheritance
- 建立一个具有共有特征的普通类，子类继承父类的所有变量和方法

```
class Superclass {…..}
class Subclass extends Superclass { .....}
```
- 每个类只能有一个父类
- 子类不能访问父类的私有成员
- 子类构造函数可以在执行其他操作之前，通过使用**super（）** 调用超类构造函数。
- 如果不调用超类构造函数，则会自动调用无参数构造函数。

### 重写
子类可以重写从父类继承的方法，需要相同的名称，参数列表和返回类型，不能重写构造函数和final和static修饰的方法。

### Encapsulation
### Abstraction 
The process of hiding the implementation details and only showing what the object does to the user.
#### 抽象类
- 此类的任何子类都必须包含其超类中所有抽象方法的实现
- 抽象类可以包含抽象和非抽象方法
- 如果抽象类的子类不包含它的所有方法，那么它也必须是一个抽象类
- 如果在类中声明了抽象方法，那么也必须声明类抽象，但是没有抽象方法的类可以标记为抽象。
#### 抽象方法
- 一个不实现的方法
- 只有抽象类才能包含抽象方法
- 抽象方法提供蓝图，但子类必须提供实现
- 接口将接口与其实现完全分离
- 必须是public或者protected

#### 接口
- 接口中只能存在public abstract 方法
- 所有方法都必须为抽象
- 如果一个非抽象类遵循了某个接口，就必须实现该接口中的所有方法。对于遵循某个接口的抽象类，可以不实现该接口中的抽象方法。
- 成员变量只能是public static final类型的

### Polymorphism

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

# 方法重载
一个类中的方法分享同一个名字，但是有不同的参数

# 内部类
在另一个类中声明的类叫做内部类，他的作用域是封闭类，可以**无条件访问**封闭类中的所有方法和变量。<br>

### 成员内部类
- 最普通的内部类。当成员内部类和外部类由同名的成员变量或者方法，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。如果要访问外部类的变量要这样：**外部类.this.成员变量。**
- 在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问。
- 成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象。


```
class Circle {
    double radius = 0;
     
    public Circle(double radius) {
        this.radius = radius;
    }
     
    class Draw {     //内部类
        public void drawSahpe() {
            System.out.println("drawshape");
        }
    }
}
```
### 局部内部类
- 局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问**仅限于方法内或者该作用域内**。
- 局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。
### 匿名内部类


### 静态内部类
- 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。
- 静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法

# 构造器
- 在对象初始化的时候定义，对已经存在的对象执行操作
- 在新的关键字创造的时候隐式调用
- 可以直接在现有对象上调用方法
- 名称必须和类名相同，不能反回任何内容


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
