# 目录
|目录|
|:---:|
|[输入URL后会发生什么](#l1)|
|[TCP和UDP协议](#l2)|
|[HTTP协议](#l3)|
|[Cookies和session](#l4)|

<br><br><br><br>

<span id='l1'></span>

# 当在浏览器中输入URL会发生什么？
## 1.请求解析URL所对应的 IP 地址。
- 将URL解析出来，拿到域名部分。
- 用DNS解析成IP地址。域名查找的过程，主要是根据域名的分级，一级一级的去找，这就是域名分级的作用。
## 2.根据 IP 地址和默认端口建立TCP连接。
第一次握手：建立连接时，客户端发送syn包（syn=x）到服务器，并进入SYN_SENT状态，等待服务器确认；SYN：同步序列编号（Synchronize Sequence Numbers）。<br/>
第二次握手： 服务器收到syn包，必须确认客户的SYN（ack=x+1），同时自己也发送一个SYN包（syn=y），即SYN+ACK包，此时服务器进入SYN_RECV状态；<br/>
第三次握手：客户端收到服务器的SYN+ACK包，向服务器发送确认包ACK(ack=y+1），此包发送完毕，客户端和服务器进入ESTABLISHED（TCP连接成功）状态，完成三次握手。<br/>

### 为什么需要第三次握手？第三次握手是为了防止已经失效的连接请求报文段突然又传到服务端，因而产生错误。<br/>

## 3.浏览器发出HTTP 请求。
客户端（浏览器）向web服务器端（HTTP服务器）发送HTTP协议包，请求服务器里的资源文档。<br/>
HTTP请求报文格式：请求行+请求头+空行+消息体，请求行包括请求方式（GET/POST/DELETE/PUT）、请求资源路径（URL）、HTTP版本号；<br/>    

## 4.服务器对请求作出响应。
服务器向客户端发送HTTP协议应答包。<br/>
HTTP响应报文格式：状态行+响应头+空行+消息体，状态行包括HTTP版本号、状态码、状态说明。

## 5.释放 TCP连接。
第一次挥手：客户端进程发出连接释放报文，并且停止发送数据。 释放数据报文首部，FIN=1，此时，客户端进入FIN-WAIT-1（终止等待1）状态。<br/>
第二次挥手：服务器收到连接释放报文，发出确认报文，ACK=1，此时，服务端就进入了CLOSE-WAIT（关闭等待）状态。TCP服务器通知高层的应用进程，客户端向服务器的方向就释放了，这时候处于半关闭状态，即客户端已经没有数据要发送了，但是服务器若发送数据，客户端依然要接受。这个状态还要持续一段时间，也就是整个CLOSE-WAIT状态持续的时间。客户端收到服务器的确认请求后，此时，客户端就进入FIN-WAIT-2（终止等待2）状态，等待服务器发送连接释放报文（在这之前还需要接受服务器发送的最后的数据）。<br/>
第三次挥手：服务器将最后的数据发送完毕后，就向客户端发送连接释放报文，FIN=1，此时，服务器就进入了LAST-ACK（最后确认）状态，等待客户端的确认。<br/>
第四次挥手：客户端收到服务器的连接释放报文后，必须发出确认，ACK=1，此时，客户端就进入了TIME-WAIT（时间等待）状态。注意此时TCP连接还没有释放，必须经过2MSL（最长报文段寿命）的时间后，当客户端撤销相应的TCB后，才进入CLOSED状态。服务器只要收到了客户端发出的确认，立即进入CLOSED状态。同样，撤销TCB后，就结束了这次的TCP连接。

## 6.浏览器将该 html 文本解析并显示内容。

## Q1.为什么TIME_WAIT状态需要经过2MSL(最大报文段生存时间)才能返回到CLOSE状态？
假象网络是不可靠的，有可以最后一个ACK丢失。所以TIME_WAIT状态就是用来重发可能丢失的ACK报文。服务器如果没有收到ACK，将不断重复发送FIN片段。所以客户端不能立即关闭，它必须确认服务器接收到了该ACK。客户端会设置一个计时器，等待2MSL的时间。如果在该时间内再次收到FIN，那么客户端会重发ACK并再次等待2MSL。如果直到2MSL，客户端都没有再次收到FIN，那么客户端推断ACK已经被成功接收，则结束TCP连接。

## Q2.为什么连接的时候是三次握手，关闭的时候却是四次握手？
因为当Server端收到Client端的SYN连接请求报文后，可以直接发送SYN+ACK报文。其中ACK报文是用来应答的，SYN报文是用来同步的。但是关闭连接时，当Server端收到FIN报文时，很可能并不会立即关闭SOCKET，所以只能先回复一个ACK报文，告诉Client端，"你发的FIN报文我收到了"。只有等到我Server端所有的报文都发送完了，我才能发送FIN报文，因此不能一起发送。故需要四步握手。

## Q3.如果已经建立了连接，但是客户端突然出现故障了怎么办？
TCP还设有一个保活计时器，显然，客户端如果出现故障，服务器不能一直等下去，白白浪费资源。服务器每收到一次客户端的请求后都会重新复位这个计时器，时间通常是设置为2小时，若两小时还没有收到客户端的任何数据，服务器就会发送一个探测报文段，以后每隔75秒钟发送一次。若一连发送10个探测报文仍然没反应，服务器就认为客户端出了故障，接着就关闭连接。
<br/><br/><br/><br/>

<span id='l2'></span>
# TCP和UDP
## TCP
优点：可靠，稳定 TCP的可靠体现在TCP在传递数据之前，会有三次握手来建立连接，在数据传递时，有确认、窗口、重传、拥塞控制机制，在数据传完后，还会断开连接用来节约系统资源。<br/>
缺点：慢，效率低，占用系统资源高，易被攻击 TCP在传递数据之前，要先建连接，这会消耗时间，在数据传递时，确认机制、重传机制、拥塞控制机制等都会消耗大量的时间，而且要在每台设备上维护所有的传输连接，事实上，每个连接都会占用系统的CPU、内存等硬件资源。 因为TCP有确认机制、三次握手机制，这些也导致TCP容易被人利用，实现DOS、DDOS、CC等攻击。<br/>
应用：浏览器，用的HTTP FlashFXP，用的FTP Outlook，用的POP、SMTP Putty，用的Telnet、SSH QQ文件传输 <br/>

## TCP编程：
### 服务端：
1.创建一个socket，用函数socket() ；
    2.设置socket属性，用函数setsockopt(); * 可选 
    3.绑定IP地址、端口等信息到socket上，用函数bind(); 
    4.开启监听，用函数listen()； 
    5.接收客户端上来的连接，用函数accept()； 
    6.收发数据，用函数send()和recv()，或者read()和write(); 
    7.关闭网络连接；
    8.关闭监听； <br/>
    
### 客户端
1.创建一个socket，用函数socket()； 
    2.设置socket属性，用函数setsockopt();* 可选 
    3.绑定IP地址、端口等信息到socket上，用函数bind();* 可选 
    4.设置要连接的对方的IP地址和端口等属性； 
    5.连接服务器，用函数connect()； 
    6.收发数据，用函数send()和recv()，或者read()和write(); 　       
    7.关闭网络连接；           

## UDP
优点：快，比TCP稍安全，UDP没有TCP的握手、确认、窗口、重传、拥塞控制等机制，UDP是一个无状态的传输协议，所以它在传递数据时非常快。没有TCP的这些机制，UDP较TCP被攻击者利用的漏洞就要少一些。<br/>
缺点：不可靠，不稳定 。因为UDP没有TCP那些可靠的机制，在数据传递时，如果网络质量不好，就会很容易丢包。<br/>
应用：当对网络通讯质量要求不高的时候，要求网络通讯速度能尽量的快，这时就可以使用UDP。QQ语音，QQ视频 ……<br/>

## UDP编程
### 服务端：  
1、创建一个socket，用函数socket()； 
    2、设置socket属性，用函数setsockopt();* 可选 
    3、绑定IP地址、端口等信息到socket上，用函数bind(); 
    4、循环接收数据，用函数recvfrom(); 
    5、关闭网络连接； <br/>
    
### 客户端：
1、创建一个socket，用函数socket()； 
    2、设置socket属性，用函数setsockopt();* 可选 
    3、绑定IP地址、端口等信息到socket上，用函数bind();* 可选 
    4、设置对方的IP地址和端口等属性; 
    5、发送数据，用函数sendto(); 
    6、关闭网络连接；   
    
### TCP与UDP区别总结：
1、TCP面向连接（如打电话要先拨号建立连接）;UDP是无连接的，即发送数据之前不需要建立连接。<br/>
    2、TCP提供可靠的服务。也就是说，通过TCP连接传送的数据，无差错，不丢失，不重复，且按序到达;UDP尽最大努力交付，即不保证可靠交付<br/>
    3、TCP面向字节流，实际上是TCP把数据看成一连串无结构的字节流;UDP是面向报文的,UDP没有拥塞控制，因此网络出现拥塞不会使源主机的发送速率降低（对实时应用很有用，如IP电话，实时视频会议等）<br/>
    4、每一条TCP连接只能是点到点的;UDP支持一对一，一对多，多对一和多对多的交互通信<br/>
    5、TCP首部开销20字节;UDP的首部开销小，只有8个字节<br/>
    6、TCP的逻辑通信信道是全双工的可靠信道，UDP则是不可靠信道
    
<br><br><br><br>

<span id='l3'></span>
# HTTP协议

## 概念
HTTP（HyperText Transfer Protocol）即超文本传输协议，是一种详细规定了浏览器和万维网服务器之间互相通信的规则， 它是万维网交换信息的基础，无状态，短连接。

## 功能
允许将HTML（超文本标记语言）文档从Web服务器传送到Web浏览器。HTTP是一种无状态的协议，无状态是指Web浏览器与Web服务器之间不需要建立持久的连接，这意味着当一个客户端向服务器端发出请求，然后Web服务器返回响应（Response），连接就被关闭了，在服务器端不保留连接的有关信息。也就是说，HTTP请求只能由客户端发起，而服务器不能主动向客户端发送数据。

## GET和POST的区别：
- get是从服务器上获取数据，post是向服务器传送数据。<br/>
- get是把参数数据队列加到提交表单的ACTION属性所指的URL中，值和表单内各个字段一一对应，在URL中可以看到。post是通过HTTPpost机制，将表单内各个字段与其内容放置在HTML HEADER内一起传送到ACTION属性所指的URL地址。用户看不到这个过程。<br/>
- 对于get方式，服务器端用Request.QueryString获取变量的值，对于post方式，服务器端用Request.Form获取提交的数据。<br/>
- get传送的数据量较小，不能大于2KB。post传送的数据量较大，一般被默认为不受限制。<br/>
- get安全性非常低，post安全性较高。

    
    
<br><br><br><br><br>

<span id='l4'></span>
# Cookie和Session
## Session
Session 是存放在服务器端的，类似于Session结构来存放用户数据，
    当浏览器第一次发送请求时，服务器自动生成了一个Session和一个Session ID用来唯一标识这个Session，并将其通过响应发送到浏览器。
    当浏览器第二次发送请求，会将前一次服务器响应中的Session ID放在请求中一并发送到服务器上，服务器从请求中提取出Session ID，并和保存的所有Session ID进行对比，找到这个用户对应的Session。
    由于Session存放在服务器端，所以随着时间的推移或者用户访问的增多，会给服务器增加负担。使用的时候要考虑下服务器的性能。
    
## Cookie
Cookie实际上是一小段的文本信息。客户端请求服务器，如果服务器需要记录该用户状态，就使用response向客户端浏览器颁发一个Cookie。客户端会把Cookie保存起来。由于Cookie是存放在客户端，是可见的，安全性就会很低。因此不建议将一些重要的信息放在cookie中。
  
## 区别：
1.cookie存放在客户端，session存放在服务器端<br/>
        2.cookie不是很安全，别人可以分析你本地的cookie信息进行cookie欺骗，因此重要信息应考虑保存在服务器端<br/>
        3.session一定时间内回报存在服务器端，当访问量增大时，会影响服务器性能，从性能方面考虑应使用cookie<br/>
        4.不同浏览器对cookie的数据大小限制不同，个数限制也不同<br/>
        5.可以考虑将登陆信息等重要信息存放为session，不重要的信息可以放在cookie中
        
## 如果客户端禁止 cookie，session 还能用吗？
如果浏览器禁止cookie，那么客户端访问服务端时无法携带sessionid，服务端无法识别用户身份，便无法进行会话控制，session失效。
### 但可以通过以下几种方法
1.URL重写：URL重写要求将站点中的所有超链接都进行改造,在超链接后用一个特殊的参数JSESSIONID保存当前浏览器对应session的编号，这样一来,当用户点击超链接访问服务器时,服务器可以从URL后的参数中分析出JSESSIONID,从而找到对应的sesison使用。<br/>
    2.用文件、数据库等形式保存Session ID，在跨页过程中手动调用

