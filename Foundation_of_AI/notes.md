# 目录

|内容引导|
|:----:|
|[AI 介绍](#intro)|
|[机器学习基础](#ML)|

# Introduction of AI
<span id = 'intro'></span>

## 几个里程碑事件

|时间|人物|内容|
|:---:|:----:|:---:|
|1943|WW2|图灵测试|
|1943|McCulloch & Pitts|第一个神经网络|
|1949|Hebb|First learning rule｜
|1956|McCarthy & Minsky|AI的诞生|
|1970s'|Lighthill...| AI寒冬，感知机无法实现基本函数|
|1980|John Searle|中文房间|
|1980s||专家系统|
|1985,1986|Parker,LeCun|发现多层神经网络解决非线性分割问题|
|1990||Bottom up approach|
|1997|IBM|AI Game, 深蓝算法|
|2002||第一个家用机器人|
|2008|Google|Speech recognition|
|2011|Watson|赢得智力竞赛节目《危险边缘》|
|2014|Goostman|图灵测试通过|

## 艾伦图灵：计算机科学之父
**图灵测试：** 两个人和一台机器，一个人是interrogator，另一个人和机器在单独的房间里。审问者无法看到房间里的东西，他的任务是通过问问题来判断对方是人还是机器，机器的任务是fool审问者，如果能fool 30%以上，就会被认为intelligent。

## 中文房间
- Searle认为图灵测试不能测试机器能够思考，智能行为不代表智能。
- 系统包括一个只会说英文的人（CPU），一本用英语写的中文手册（program）和一叠纸（容器设备）。
- 房间里的人可以只根据翻英文手册来用中文回复。
- 因此，运行程序并不能产生understanding，智能表现的像懂中文。
- Searle提出强AI是指系统具有mind和mental states，弱AI只行为表现的智能。
<br><br>



# 机器学习
<span id = 'ML'></span>

**定义：** 计算机从代表“过去经验”的数据里学习。<br>
**训练集：** 学习模型的参数。<br>
**测试集：** 评价模型的**泛化能力（generalization）**，推广到一个新的独立数据集。<br>

## 有监督学习VS无监督学习

|有监督学习|无监督学习|
|:---:|:----:|
|观察一些输入输出数据的例子学习一个从输入到输出的映射函数。<br>给定input x和labels y去学f(x)。|只给你samples x，让你去推断f(x)来描述unlabeled data的隐藏结构|
|**分类问题：** y是离散的（class label），学习决策边界去分类他们。<br> **回归问题：** y是连续的，学习连续的输入-输出映射，也叫“curve fitting”或者“function approximation”。|**聚类问题：** y是离散的，学习数据中存在的内在结构。<br> **降维问题：** y是连续的，发现数据的低维度平面。|

# 数据挖掘
**定义：** 对大量的数据进行分析和探索，以发现其中**有效的、新颖的、潜在有用的、最终可理解的pattern。**

## 数据挖掘方法
- 分类
- 聚类
- 关联法则
