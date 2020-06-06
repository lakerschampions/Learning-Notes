# 目录

|课件序号|课题名称|
|-----|------|
|Lecture 01|[介绍](#lec1)|
|Lecture 02|[用户需求](#lec2)|
|Lecture 03|[需求收集](#lec3)|
|Lecture 04|[需求建模](#lec4)|
|Lecture 05|[需求验证](#lec5)|


# 介绍 
<span id="lec1"></span>
## 软件
**定义：** Software is something that is working, usually for ‘real humans’ to use to help them do something.<br/>
**组成部分：** The compiled code, documentation, configuration components, installation/upgrade.

## 软件工程的定义
The application of a systematic, disciplined, quantifiable approach to the development, operationand maintenance of software. That is, the application of engineering to software.

## 软件过程
![SEprocess](https://github.com/lakerschampions/Learning-Notes/blob/master/images/seprocess.png?raw=true)
60%用与设计和构造软件，40%用于测试和交付软件，通常维护软件的成本往往比生产高。<br/>


## 几种常见的软件工程模型
### 瀑布模型和V模型（waterfall&V）

<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/waterfallmodel.png?raw=true"  width="400" height="250"><img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/vmodel.png?raw=true"  width="400" height="250">

**特征：** 以文档为驱动，每个阶段都有与其相关的里程碑和交付产品，每个阶段结束前完成文档审查改正错误。<br/>
**缺点：** 1.需要稳定和完美的需求，无法应对需求的变化。2.无法进行修订或重构，过于inflexible和static。3.会产生许多连锁反应，无法进行迭代。4.工作量太大，会产生很多文档。

### 迭代、螺旋模型（iterative）

<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/iterativespiral.png?raw=true"  width="500" height="350">

**特征：** 将开发和风险评估结合起来。将开发过程分成好多次迭代，每次迭代代表一个阶段，将一次迭代放在一个坐标轴里，四个象限分别代表：**1.明确目标、选择、约束**，**2.评估方案、风险分析、构建原型**，**3.开发验证**，**4.计划下阶段**。结合了瀑布模型和原型模型，适合比较复杂风险较大的系统。<br/>
**缺点：** 1.系统结构通常不良 2.做得太多而计划不足，增加成本和时间。3.要求开发团队具有特殊技能。



# 用户需求 
<span id="lec2"></span>
<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/requirementsprocess.png?raw=true"  width="500" height="400">

## 需求工程
### 需求引出
**初始方法：** <br>
**Stakeholder Analysis:**<br>
**Personas:**<br>
**use case diagrams:**<br>
**user stories**<br>

# 需求获取
## 需求的分类：功能性vs非功能性
**功能性需求：** 描述系统应该做什么，为用户和其他系统完成的功能服务。<br>
**非功能性需求：** 必须遵照的标准，约束条件，质量属性。

## 获取需求的方式
**Surveys:**<br>
**Interviews & Focus Group:**<br>
**Observations:**<br>
**Technology Tours:**<br>
**Ethnography:**<br>

# 需求验证
**目的：** <br> 
1.Checking that you are right：确认系统是不是用户真正想要的。<br> 
2.Avoiding reworking：避免再次修改带来的巨大成本。<br> 
3.Contractually Agreeing：在项目的某一个阶段，你需要决定到底真正想做什么，你需要让所有人同意你造的东西。
  - 你要展示给你的老板和同事（Internal），采取“Requirements Review”的方式，与你的团队合作，将需求、计划、预算等介绍给你的经理。
  - 如果遇到问题，就不能进行外部验证，如果是缺少的部分就要进行更多的elicitation，如果是冲突，记录下来问题与客户沟通。
  - 必须和用户达成一致（external），其实就是和用户做“Requirements Review”。
<br>

**需求规格文档：** <br> 1.把用户的需求翻译成正式的文档， **“做什么”** 而不是“怎样实现”。2.通常是一大组嵌套的列表，具有唯一的ID。3.生成的图表与之匹配。4.清单被分类（重要性、风险）。5.项目结束时定义验收测试。
