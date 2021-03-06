# PortraitOfJobSeeker
# 项目背景
大数据和“云计算”像是一枚硬币的正反面一样慢慢勾勒出当今世界的财富价值风向。大数据的出现得益于互联网行业的快速发展、计算机硬件和软件能力的不断提升。大数据技术现已被应用到各行各业，而在招聘求职领域，我们希望通过爬虫技术、机器学习、文本挖掘、统计分析等手段帮助求职者更好的了解市场需求，从而有一个清晰、明确的求职方向。
# 项目说明
### 问题说明
本系统首先需要通过网络爬虫爬取智联招聘、51job等招聘网站上，大数据相关职位的招聘信息，提取出其中的关键数据，包括但不限于职位名称、职位待遇、职位描述、公司介绍、公司规模、公司性质等信息。通过对这些信息的挖掘分析，可以更加精准、清晰的指导求职者所在行业的待遇水平、自身可能的待遇、以及对公司、行业的选择。
### 用户期望
1.	探索学历、专业、学校、求职地、工作年限、技能、工作经历等因素对求职的影响。
2.	求职者可以通过该系统完成对自己职业选择的辅助分析。
3.	通过搭建大数据采集、分析、展示平台，提升大学生对大数据技术的理解和熟悉。
# 项目要求
### 技术路径
通过爬虫技术对网站上的求职信息进行收集，再利用大数据平台，对网上收集下来的数据进行分析挖掘，挖掘出岗位、工资、学历、待遇等不同因素之间的关系，形成高价值信息。
### 技术指标
1.	网络爬虫首先根据选定的网站列表进行爬取。为提高爬取效率，整个模块应支持爬虫的水平扩展，并且可基于开源系统实现。场景举例：系统管理员可以对网站列表进行增加、删除、修改操作，可以设置开始爬取的时间，爬取的频率（每天一次或者每天两次等），设置完毕后，网络爬虫根据指定的条件进行爬取。爬虫支持深度优先或广度优先策略，要求提供自研算法。
2.	对于爬去的数据支持丰富的解析能力，要求提供优质挖掘算法或解析规则。在对爬取的数据进行结构化处理的基础上，要求参赛者分析：a.岗位工资的影响因素；b.岗位能力需求图谱；c.岗位的招聘企业画像等三大主题，为下个环节的智能推荐做准备。
3.	当求职者输入学历、专业、学校、求职地、工作年限、技能、岗位名称等基本信息后，系统将智能分析出该职位的待遇水平、求职者的待遇区间、可能去的公司、公司性质和规模、行业、匹配概率等信息。要求：求职者画像及岗位个性化推荐算法。
# 任务清单
需求1：网络爬虫抓取企业岗位需求的信息；<br>
需求2：数据分析和数据挖掘并形成岗位画像；<br>
需求3：求职者岗位的个性化智能推荐并形成求职者画像。<br>
# 项目摘要
	此系统是对于公司招聘人员以及求职人员的智能推荐求职人员以及招聘公司的系统。
### 招聘人员
公司招聘人员登入网页客户端，将招聘期望信息（例如学历、学校、专业、办公地、工资、技能、岗位等等）输入到客户端，点击“搜索”进行个性化智能推荐（系统将会在“求职鱼塘”中挖掘信息），将符合要求的求职大学生的信息以匹配程度由高到低的顺序罗列出来，供公司招聘人员选择。招聘人员点击详情进一步查看该求职人员是否符合本公司招聘需求，如若满意则双方进行联系与沟通。
招聘公司如果有长时间招聘的意愿，登录客户端后，将招聘信息（包括公司信息）填写并存放到“招聘鱼塘”，系统将不定期的推送给浏览相应职位的求职人员，以保证公司的招聘效率。当招聘公司招满或其他原因不在招聘时，那就登录客户端撤回或暂停招聘信息的推广。
### 求职人员
求职人员登入客户端，将求职信息（例如学历、学校、专业、求职地、工资、岗位等等）输入到客户端。点击“搜索”进行个性化智能推荐（系统将会在“招聘鱼塘”中挖掘信息），将符合要求的招聘公司信息以匹配程度由高到低的顺序罗列出来，供求职人员选择。求职人员点击详情查看招聘公司是否符合自己的预想期望，如若满意则向该公司投入简历，等待对方回复。
求职人员如果长期找不到合适的工作或者频繁跳槽，待登录客户端后，将求职信息填写并存放到“求职鱼塘”，系统将不定期的推送给浏览相应招聘信息的招聘人员，以保证求职者的求职效率。当求职人员被聘用或者其他原因不在求职时，那就登录客户端撤回或暂停求职信息的推广。
