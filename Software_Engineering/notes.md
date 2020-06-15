# 目录

|课件序号|课题名称|课件序号|课题名称|
|-----|------|-----|------|
|Lecture 01|[介绍](#lec1)|Lecture 11|[单元测试&测试驱动开发](#lec11)|
|Lecture 02|[用户需求](#lec2)|Lecture 12|[发布测试&验收测试](#lec12)|
|Lecture 03|[需求收集](#lec3)|Lecture 13|[配置部署](#lec13)|
|Lecture 04|[需求建模](#lec4)|Lecture 14|[发展维护](#lec14)|
|Lecture 05|[需求验证](#lec5)|Lecture 15|[软件质量](#lec15)|
|Lecture 07|[规范](#lec7)|Lecture 16|[敏捷开发](#lec16)|
|Lecture 08|[原型](#lec8)|Lecture 17|[风险管理](#lec18)|
|Lecture 09|[面向对象设计和测试计划](#lec9)|Lecture 19|[项目计划](#lec19)|
|Lecture 10|[实施](#lec10)|


<br><br><br><br>

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

## 课后问题

### 为什么我们有软件工程方法？

### 为什么软件工程方法很重要？

### 软件工程的四个主要方面是什么？
Specification,Development,Verification,evolution

### 现有哪些SE方法？
traditional methods;agile methods

### 最便宜和最昂贵的问题是什么？

<br><br><br><br>
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

<br><br><br><br>

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

## 课后问题
### 有什么区别？

### 如何做好需求收集工作？

### 功能性需求和非功能性需求有什么区别？

### 如何建立需求模型？用户、任务等？

### 你能用UML做什么？UML的类型？

<br><br><br><br>

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

<br><br><br><br>

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

<br><br><br><br>

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
<br><br><br><br>
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

## 课后问题

### 编写规范的主要方法？规范符号类型？

### 我们为什么要创建原型？

### 为什么要制作类图？


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
- 需求的可追溯性，需求和测试之间的联系
- 被测试的items
- 测试日历
- 测试记录的过程
- 需要什么样的硬件和软件的配置
- 将要测试的所有精确用例
<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/testplandocument.png?raw=true"  width="700" height="350">

## 设计测试用例
**需要包含：** 正在测试的内容的声明，测试输入的规格，预期输出，测试所需步骤。
<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/testcase.png?raw=true"  width="800" height="250">

## 测试类型
**验证测试（Validation Testing）：** 先是软件测试会显示的正确答案。<br>
**缺陷测试（Defect Testing）：** 显示软件不会中断的测试。

## 课后问题
### 为什么要制定测试计划？

### 黑盒和白盒有什么区别？单元、集成、发布、验收和用户测试？

### 什么是测试驱动开发？
<br><br><br><br>

# 实施（implementation）
<span id="lec10"></span>

- **Developer：** 建造一个特殊的类，将代码交付给团队审批和使用。
- **The Development Team Manager：** 证明整个系统已完成，交出文件。
- **The Integration Team：** 集成类，并构建主系统。

## 编写代码的策略
- **Test-Driven Development：** 在编写代码之前，编写他必须通过的自动测试；然后在编写代码，等他通过测试就说明完成了。
- **Comment-Driven Development：** 先写注释，然后用代码填充注释。
<br><br><br><br>

# 单元测试&测试驱动开发
<span id="lec11"></span>

|白盒测试|黑盒测试|
|:---:|:---:|
|透明的测试，知道代码是如何工作的|不知道代码是如何工作的，只知道输入输出是什么|
|面前通常都有代码|通常运行编译后的版本|
|用于开发测试|用于发布测试和验收测试|
|**自动化测试**|**手动测试**|
|大量的脚本和编码测试|高等级的测试|
|在代码编译/提交时运行|在计划阶段运行-关键阶段结束|
|可以内置到版本控制平台|通常在准备好测试的代码上运行|

**TDD的优点：** 它集成了规范、编码和测试的各个方面；在构建代码之前，让您考虑如何使用代码；这意味着您在“编写”代码之前先“计划”代码；这意味着你要从全局出发，而不是从当前的功能出发；当要修改代码的时候，他会帮你检查之前还可以通过的代码。
<br><br>
<br><br>
# 发布测试&验收测试
<span id="lec12"></span>
<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/testphase.png?raw=true"  width="700" height="350">

## 集成测试（子系统测试）
将软件集成起来进行测试。因为两个模块如果单独运行正常，但合在一起有可能出毛病。

## 发布测试（系统测试）
从用户使用的角度进行测试，将完成了集成测试的系统放在真是的运行环境下运行，是validaiton testing而不是defect testing，是**黑盒测试**。

## 验收测试
在发布测试之后，软件正式使用前的最终测试阶段，使用客户提供的真实数据进行测试。还可能揭示出系统不能满足的用户需要或者系统不可接受的表现。
<br>
<img src="https://github.com/lakerschampions/Learning-Notes/blob/master/images/acceptancetesting.png?raw=true"  width="700" height="150">
<br>
**测试步骤：** 定义测试标准 -> 计划验收测试 -> 导出验收测试 -> 进行测试 -> 协商测试结果 -> 接受/拒绝系统
<br><br><br><br>

# 配置部署
<span id="lec13"></span>
Release management is a continuous strategy planning for releases

|开发频道名称|描述|
|:---:|:----:|
|Stable versions|当前稳定版本|
|Beta versions|官方版本|
|Dev versions|比每周更新更加频繁|
|Canary builds|每日发布，一建成就发布|

## 持续集成工作流程
**版本控制->持续集成->建造配置->自动部署**

## 持续集成的概念
持续集成（CI）是一种实践，可以让团队在持续的基础上收到反馈并进行改进，不必等到开发周期后期才寻找和修复缺陷。通俗一点儿说，就是指对于开发人员的每一次代码提交，都自动地把Repository中所有代码Check out到一个空目录，并且自动运行所有Test Case。如果成功则接受这次提交，否则告诉所有人，这是一个失败的Revision。

## 课后问题
### 团队如何通过分支来管理以前的版本？

### 持续集成对主代码有什么帮助？
减少风险，减少重复过程，产生可部署的软件，使项目更加透明。

### 如何以及为什么使用生成配置来创建多个生成？
原因：需要在不同平台，不同配置上发布。

### 重要问题：如果验收测试是为了与客户一起工作，那么什么情况下发布管理更适合？
<br><br><br><br>

# 发展维护
<span id="lec14"></span>

**维护的作用：** 纠正先前没有发现的错误；改进系统单元的实施；在发现新需求时增强系统的服务。<br>
**维护的花费：** 
- 团队的改变
- 职员的技能水平
- 项目的寿命和结构
- poor的开发训练
- 不实际的需求和设计，没有意义的命名
- 复杂的方法，糟糕的代码

<br>

**三种改变的方法：**
- 修改代码错误，往往比较便宜
- 环境适应，更新操作系统，成本更高
- 添加功能，满足业务变化，需要重新设计

## 需求变更管理
**定义：** 根据新的需求改变，跟踪发现了什么变化。需求需要唯一的ID以便于交叉引用。只有首先指定每个规范支持的需求，才能理解对规范/设计的影响。<br>
**步骤：** 问题分析，变更规格 -> 改变分析和花费 -> 改变实施

## 重构
通过对程序进行改进来减缓降级速度，通常被认为是“preventative maintenance”。所有的更改都便宜了最初的计划，降低了代码质量。<br>
**需要重构的部分：** 重复相似的代码；长方法；数据聚集；推测性的未来代码

## 课后问题
### 为什么在维修阶段修理东西比较贵？

### 变化的主要类型是什么？
修改代码错误；环境适应，更新操作系统；添加功能满足业务变化

### 为什么变更管理很重要？它是如何工作的？

### 为什么重构很重要？你应该什么时候用？你应该如何处理紧急变化？

### 如何以不同的方式考虑软件维护，使其更容易/更便宜，并且更像正常的SE？
<br><br><br><br>

# 软件质量
<span id="lec15"></span>
软件质量意味着做好每一个方面

## QA团队
**目标：** 改进项目之间的流程，记录工作良好的方面，将成功的流程应用于其他项目，**提高公司的质量保证标准。**
### 制定质量计划：为团队设定实现目标的标准
项目质量文件的关键部分：
- 产品介绍：预定市场等
- 产品计划：关键发布日期、维护等
- 流程描述：此项目将遵循什么流程
- 质量目标：最终产品的关键质量属性
- 风险和风险管理：预期的关键风险领域。

### 确定整个公司的标准和程序
运用过程标准，产品标准（ISO Standards）

### 检查项目是否符合公司标准

## 课后问题
### 质量保证团队应该做的3（4）件事是什么？为什么这是一个元项目问题？

### 你什么时候应该关心软件质量？

### 应该什么时候进行审查和检查？（比较传统方法与敏捷方法）为什么评审在某种形式上如此有价值？

### 为什么质量驱动的文化比权威的质量管理更好

### 如何衡量代码的质量？

### 关于验收测试的思考：什么时候是让客户参与的最佳时机？确保他们对产品满意的最佳方法是什么？
<br><br><br><br>

# 敏捷开发
<span id="lec16"></span>

## 敏捷开发 VS 传统开发
|敏捷开发|传统开发|
|:---:|:-----:|
|瀑布模型，V模型|迭代模型|
|需求表|用户故事，personas|
|UML|快速原型|
|正式的用户测试|用户交互|
|集成测试阶段|持续集成，TDD|
|部分技能的团队|全面技能团队|

## 四大核心价值观
- 流程和工具上的个人和交互
- 工作软件优于全面的文档
- 合同谈判中的客户协作
- 根据计划对变更做出响应

|极限编程（XP）|Scrum|Kanban|
|:---:|:-----:|:-----:|
|周期更小的螺旋开发，每天更新版本|通过冲刺循环|我们下一步要做什么，用kanban来管理当前工作|
|通过结对编程，集体所有权和避免长时间工作实现个人和互动||将所有要构建的内容保存在一个列表中，优先级可以随时刷新|
|通过频繁的小型系统发布来支持工作软件||发布周期是构建功能所需时间的度量|
|客户协作意味着客户参与|||
|通过定期发布来响应变化|||

## 课后问题
### 他们是什么时候和为什么被介绍的？
WHEN：2001<br>
WHY：快速软件开发模型变得越来越重要，全球业务发展迅速，很多项目在改变mid-process;传统模型有太多局限性（依赖过大的文档，debug费用高，很难应对在项目过程中的变化）

### 他们如何努力改进传统方法？

### 什么时候不应该使用敏捷方法？
1.当软件无法使用迭代法开发的时候。2.当客户不能全身心投入工作时。3.开发人员位于不同时区，或者整个团队规模太大。

### 说出敏捷的4个关键价值观。
- Individuals and interactions over processes and tools
- Working software over comprehensive documentation
- Customer collaboration over contract negotiation
- Responding to change over following a plan 

### 什么是极限编程？如何衡量进展？
XP是一种快速的“极端”迭代开发方法。新的版本可能每天都在构建，或者更频繁地构建，每两周向客户交付一次增量。在接受生成之前应用所有测试，生成只有在通过所有测试时才被释放。
XP是一种近螺旋式的开发方法，它将复杂的开发过程分解为一个个相对比较简单的小周期；通过积极的交流、反馈以及其它一系列的方法，开发人员和客户可以非常清楚开发进度、变化、待解决的问题和潜在的困难等，并根据实际情况及时地调整开发过程。

 
### SCRUM是如何工作的？
1.计划并概述你将实现的目标。2.设定一系列“sprint cycles”来完成工作。3.记录当前阶段

### SCRUM如何匹配这4个关键值？
- 客户协作意味着与团队的全职客户参与。
- 通过频繁的小型系统发布支持工作软件。
- 通过结对编程、集体所有权和避免长时间工作的过程实现个人和互动。
- 通过定期发布系统来应对变化。

### 敏捷最重要的是什么？
**Be agile.**
### 为什么编码和命名约定很重要？-什么是编码启发式？

### 你如何分配工作？

### scrum的方法是什么？

### 配对编码对团队有什么价值？

### 主要的调试策略是什么-橡皮鸭有什么好处？

### 问题、里程碑等是如何帮助敏捷团队通过git存储库进行协作的？
<br><br><br><br>

# 风险管理
<span id="lec18"></span>

## 软件风险
### 如何减少风险
- 危险避免
- 危险检测&移除
- 危害限制

## 项目风险
### 风险策略
- **规避策略（Avoidance strategies）**-为降低风险而采取的行动
- **最小化策略（Minimization strategies）**-如果发生，减少影响
- **应急计划（Contingency plans）**-如果发生，你将做什么/改变什么

## 课后问题
### 为什么风险分析很重要？我们应该如何评估风险？

### 我们什么时候应该考虑风险？

### 软件风险和项目风险有什么区别？
软件风险：软件绝不应该发生什么

### 处理项目风险有哪些策略？
- Avoidance strategies - actions taken to reduce the risk happening
- Minimization strategies - reducing the impact if it happens
- Contingency plans - what you will do/change if it happens 

### 在做了软件风险分析之后，项目有什么变化？

<br><br><br><br>

# 项目计划
<span id="lec19"></span>
## 课后问题
### 什么是甘特图？什么是PERT图？

### 关键路径是什么？为什么？如何计算？
The longest path (worst case) is the critical path which helps you cost the effort for the worst case rather than the best case.

### 关键路径任务迟到有什么关系？

### 我们如何估算一个项目的成本？
1.估计项目完成的最小/最大时间。2.添加应急估计。3.基于经验的知识。4.算法成本建模。

### 什么因素导致项目成本与销售价值的差异？

### 深层次的问题：敏捷时间规划与传统的时间规划有何不同？为什么这有时比项目经理和客户更可取？
