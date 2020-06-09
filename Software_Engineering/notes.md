# 目录

|课件序号|课题名称|
|-----|------|
|Lecture 01|[介绍](#lec1)|
|Lecture 02|[用户需求](#lec2)|
|Lecture 03|[需求收集](#lec3)|
|Lecture 04|[需求建模](#lec4)|
|Lecture 05|[需求验证](#lec5)|
|Lecture 07|[规范](#lec7)|
|Lecture 08|[原型](#lec8)|
|Lecture 09|[面向对象设计和测试计划](#lec9)|

<br><br>

# 介绍 
<span id="lec1"></span>
## 软件
**定义：** 软件是可以工作的东西，通常是用来帮助“real humans”做一些事情。<br/>
**组成部分：** The compiled code, documentation, configuration components, installation/upgrade.

## 软件工程的定义
在软件的开发、操作和维护中应用一种系统的、有纪律的、可量化的方法。即工程在软件中的应用。

## 软件过程
![SEprocess](https://github.com/lakerschampions/Learning-Notes/blob/master/images/seprocess.png?raw=true)
60%用与设计和构造软件，40%用于测试和交付软件，通常维护软件的成本往往比生产高。<br/>


## 几种常见的软件工程模型
### 瀑布模型和V模型（waterfall&V）

<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/waterfallmodel.png?raw=true"  width="400" height="250"><img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/vmodel.png?raw=true"  width="400" height="250">

**特征：** 以文档为驱动，每个阶段都有与其相关的里程碑和交付产品，每个阶段结束前完成文档审查改正错误。<br/>
**缺点：** 1. 需要稳定和完美的需求，无法应对需求的变化。2. 无法进行修订或重构，过于inflexible和static。3. 会产生许多连锁反应，无法进行迭代。4. 工作量太大，会产生很多文档。

### 迭代、螺旋模型（iterative）

<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/iterativespiral.png?raw=true"  width="500" height="350">

**特征：** 将开发和风险评估结合起来。将开发过程分成好多次迭代，每次迭代代表一个阶段，将一次迭代放在一个坐标轴里，四个象限分别代表：**1. 明确目标、选择、约束**，**2. 评估方案、风险分析、构建原型**，**3. 开发验证**，**4. 计划下阶段**。结合了瀑布模型和原型模型，适合比较复杂风险较大的系统。<br/>
**缺点：** 1. 系统结构通常不良 2. 做得太多而计划不足，增加成本和时间。3. 要求开发团队具有特殊技能。


<br><br>
# 用户需求 
<span id="lec2"></span>

## 需求工程

<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/requirementsprocess.png?raw=true"  width="500" height="400">

## 需求引出和分析

|初始方法|介绍|优缺点|
|:---:|:----:|:---:|
|**Stakeholder Analysis**| **目的：** 确认所有会用该系统的人。主要、次要、第三方利益相关者。||
|**Personas**|代表真实的利益相关者类型，但是不是真人的报告。制作两三个 **key user type**。<br> **目标：** 清楚的区分所有的利益相关者。||
|**Use case diagrams** |详细的说明每个利益相关者要完成的任务，用actors和case。||
|**User stories**| 将actors和case放在一起并且加上原因。“As a **role**, I want **goal/desire** so that **outcome**” (a role, a goal and an effect/outcome/motivation)。在敏捷开发中经常被使用。|简洁明了，维护成本低，创造了一个清楚的需求清单，可以将项目分解成块根据重要性排序。在大型项目中很难使用，缺少细节和正式术语，无法描述过程、任务和上下文。|

<br><br>

# 需求收集
<span id="lec3"></span>
## 需求的分类：功能性vs非功能性
**功能性需求：** 描述系统应该做什么，为用户和其他系统完成的功能服务。<br>
**非功能性需求：** 必须遵照的标准，约束条件，质量属性。

## 获取需求的方式

|方式|介绍|优缺点|
|:--:|:-----:|:------:|
|**Surveys**||有助于获得大多数人的意见但是不利于理解细节。常见的错误：发送错误的问卷，被精心设计来获得偏向性的答案。第二常见的错误：reinvent the wheel。其他问题：2 parts questions, leading questions, surveys are too long。|
|**Interviews & Focus Group**|允许自由的提问，面试管思想开放鼓励交流。往往不只是在talk，还会展示一些图表让你展开讨论。|常见错误：没有计划和todo list。可以讨论不同的观点，更快地覆盖用户，但是可能产生矛盾，诞生主导发言者或者讨论时间太长。|
|**Observations**|看到别人没说到的东西因为人们很少了解到整个情况。||
|**Technology Tours**|发现了解任务中的所有技术。帮助你确定软件将使用哪些功能。||
|**Ethnography**|感觉不是很重要😂|

<br><br>

# 需求模型
<span id="lec4"></span>
**模型的作用：（不止在需求分析中）** 1. 导出需求。2. 在设计过程中描述系统工程师实现的东西。3. 在实现后记录系统结构和操作。

|模型名称|介绍|
|:-------:|:----:|
|上下文模型| 在收集需求的时候，确定了许多需要交互的系统，你想知道这些系统是如何关联的（大部分是用于非功能性需求）。定义了系统的边界，代表了需要开发的关键系统和其他系统、组件的关系，并且还有不开发的系统。|
|任务分析|用于标识子任务，不利于过程，没有decision points，没有actors|
|Scenarios|**MUST** define a setting or context<br> **MUST** define one or more actors or users<br> **MUST** define goals or objectives<br> **MUST** describe a plot,the plot describes how a user,in a context,achieves a goal|
|**UML图**|**BELOW⬇️⬇️⬇️**|
|活动图|黑球代表开始，黑心球代表结束，bar代表并行，diamond代表决策，用于详细说明关键活动的工作流（尤其是涉及决策的时候），通常是为了详细定义一个use case。|
|顺序图|有利于人与系统之间复杂信息的共享，可被视为关键部分之间的一系列信息。|
|类图|在面向对象的代码中制定类|
|状态图|表示某物可能存在的状态|



<br><br>
# 需求验证
<span id="lec5"></span>
**目的：** <br> 
1. Checking that you are right：确认系统是不是用户真正想要的。<br> 
2. Avoiding reworking：避免再次修改带来的巨大成本。<br> 
3. Contractually Agreeing：在项目的某一个阶段，你需要决定到底真正想做什么，你需要让所有人同意你造的东西。
  - 你要展示给你的老板和同事（internal validation），采取“Requirements Review”的方式，与你的团队合作，将需求、计划、预算等介绍给你的经理。
  - 如果遇到问题，就不能进行外部验证，如果是缺少的部分就要进行更多的elicitation，如果是冲突，记录下来问题与客户沟通。
  - 必须和用户达成一致（external validation），其实就是和用户做“Requirements Review”。
4. Specification也可以进行需求验证。

**需求规格说明书（SRS）：**
- 把用户的需求翻译成正式的文档， **“做什么”** 而不是“怎样实现”。
- 通常是一大组嵌套的列表，具有唯一的ID。
- 生成的图表与之匹配。
- 清单被分类（重要性、风险）。
- 项目结束时定义验收测试。

<br><br>

# 规范
<span id="lec7"></span>

## 规范 (vs 需求)

|类型| 功能| 对象|定义|
|:---:|:----:|:----:|:---:|
|**需求(用户):** |What a stakeholder needs to be able to do.|Client managers,System end-users,Client engineers,Contractor managers,System architects|系统所要实现的**功能和性能**，系统的运行环境和发展前景。是项目的基础，定义了所需要的质量水平便于决策，为之后的测试打下基础|
|**规范(系统):** |What the software must do to meet the requirement above.|System end-users,Client engineers,System architects,Software developers|对系统的功能、服务、约束更加细节地描述，将要实现什么。系统将**如何满足**用户的需求，通常以表格形式列出。|

**需求与规范的区别：** 需求是指从**业务用户**的角度来看业务需求，而规范是从**系统**的角度定义需求；需求表示问题或需要而规范提供了问题的解决方案；需求是从企业用户/利益相关者收集，而规范则是由技术团队提供的他们心里的需求。；需求的输入是业务用户，而规范的输入是需求文档、业务用户和技术团队。

## 几种规范的格式

|名称|介绍|
|:----:|:---:|
|**Natural Language**|可以通俗直观也可以模棱两可。<br> **标准格式：** 用一句话链接到用户的序曲，区分强制的（shall）和可取的（should），强调重要元素，避免使用行话，确保**measurable** 。|
|**Structured**|将规范制成表格或者放在模版里。可以指定附加条件。|
|**Graphical**|UML图、原型。当发现规范很复杂，可以将他们可视化。|
|**Mathematical**|没有详细介绍 T^T|

 ## 一个好的系统规范
 - **Tracebility：** 所有的规范都可以追溯到用户需求，在报告中要写清楚支持的用户需求，可以按照重要性、难度分类。
 - **Testability：** 你需要知道你实现了这个规范指定的内容，要让规范可测试。

## 需求文档检查
- **Validity checks:** 不同用户使用不同功能的有效性。
- **Consistency checks:** 需求之间不能冲突。
- **Completeness checks:** 包括所有用户想要的需求和约束。
- **Realism checks:** 是否能被现有技术实现。
- **Verifability checks:** 是否能被测试。
<br><br>
# 原型
<span id="lec8"></span>
<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/prototype.png?raw=true"  width="800" height="400">
<br>
**定义：** 一种设想所有规格协同工作的方法，测试规范的一致性，是系统具体但 **部分** 的实现。

|Low Fidelity|High Fidelity|
|:---:|:---:|
|草图、纸模型|自动化软件|
|潜在的想法|与最终产品相似|
|关键的功能|准确的细节|

**目的：** 1. 技术的作用 2. 看和感觉 3. 实施指南<br>
**风险：** 
- 在high fidelity上投入过多时间和花费。
- Adhoc的代码被用在了实际系统里。
- 原型替代了文档的作用。
- 被错误的stakeholder批准。
<br><br>

# 面向对象设计和测试计划
<span id="lec9"></span>
<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/OOD.png?raw=true"  width="600" height="400">

## 如何进行面向对象设计
- 理解并定义上下文和外部与系统的交互。
- 设计系统体系结构。
- 标识系统中的主体对象
- 开发设计模型
- 指定接口

## 测试计划（作为设计的一部分）
<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/testplan.png?raw=true"  width="800" height="350">

**开发测试计划（Development）：** 证明类功能正确。<br>
**系统/集成测试计划（System/Integration）：** 证明软件符合规范，组件接口是否正确。<br>
**开发测试计划（Acceptance）：** 表明软件符合要求，经常用客户端完成。<br>

### 测试计划中需要写的部分
- 测试过程，对方法的描述
