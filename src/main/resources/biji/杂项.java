

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Linux
注意下面演示使用的Ctenos6.3,版本;
Linux(1994年问世)
继承与unix(1973年样子)百分之70命令一样.
特点:
1,免费/开源
2,支持多线程/多用户
3,安全性好(因为开源,一旦bug网络雷锋会帮修复)
4,对内存和文件管理优越(linux最小只需要4M)
5,linux 中一切皆文件,包括硬件,用户等(windows不一样)
6,linux不靠扩展名区别文件类型,只靠权限来管理
但 我们一般约定:
压缩包:.gz,.bz2,tar.bz2,.tgz等
*.rpm(Red-Hat Package Manager)
~~~~~~~~~~~~~~~~~~
网页文件:.html,.php
脚本文件: .sh
配置文件: .conf
有了约定我们更方便的使用而已.

7,windows下的程序不能直接在linux中直接安装和运行(这样更为安全)

查看链接对应服务器是什么:  www.netcraft.com
+++++++++++++++++++++++++++++++++++++++++++++++++++
精华:
格式化的作用是写入文件系统(FAT16,FAT32,NTFS,Ext2,Ext3,Ext4),
写入文件系统时,会对硬盘重新分块(默认一个块是4kb),这样会清空磁盘中的数据,同时会有一部分块记录着磁盘其他块的Id号,
数据写入不一定是连续块中,而是一个通过一串id号把数据窜接起来的;
+++++++++++++++++++++++++++++++++++++++++++++++++++
分区设备文件名
首先linux 一切皆文件,硬件能使用也必须要有一个文件名(文件名不要使用中文)和它对应
linux所有硬件文件名都放在/dev/下
如:
/dev/hda1 -- ide硬盘hd开头,a标识第一个硬盘,1,表示第一个分区
/dev/sdb1 -- SCSI,SATA; sd标识这种接口的硬盘 sata比scsi快,b是第二块硬盘
+++++++++++++++++++++++++++++++++++++++++++++++++++

分区的作用就是方便管理,主要作用就是这个其中一个分区写满了,不会影响其他分区,这点很重要

必须分区:
swap 分区 (交换分区,内存小于4G是内存2倍,大于则等于内存大小),作用是虚拟内存;
推荐分区:
/boot (启动分区,200MB),分了后好处是:/分区就算写满了,也不会影响启动;
/ 根分区 (分了其他分区大小后全部容量都给它)
+++++++++++++++++++++++++++++++++++++++++++++++++++
挂载:

挂载如同windown系统中的盘符(C,D,E)

linux 分区必须挂载后才可以使用,挂载就把分区挂载一个目录或文件下(任何目录或文件),
挂在哪个目录(或文件)下的哪个位置就叫挂载点;
+++++++++++++++++++++++++++++++++++++++++++++++++++
linux 的最高层/目录,其他所有目录都在它之下,但并不是所有的目录都在一块硬盘下;
/home 我们可以设置它的挂载点/dev/sda2
/boot 我们可以设置它的挂载点/dev/sdb1
上面2个目录在一个在a硬盘第二分区中,一个在b硬盘的第一分区中;
/dev/sdb2:sd表示sata或scsi(老式服务器接口,速度大概在200每秒)接口的硬盘,b表示第二个硬盘,2表示第二个分区
---------------
分区:把硬盘分为小的逻辑分区
分区设备文件名:给每个分区定义设备文件名
挂载:给每个分区分配挂载点(把盘符和分区连接起来)
挂载点就是挂在那个文件或目录的位置;(相当于windows中的盘符)
-------------------------------
初始化安装后linux就会生成这3个文件:
安装日志:
/root/install.log:存储了安装在系统中的软件包及其版本信息;
/root/install.log.syslog:存储了安装过程中留下的事件记录;
/root/anaconda-ks.cfg:以Kickstart配置文件的格式记录安装过程中设置的选项信息.(批量安装使用它)

--------------------------------------------
一,linux的基本格式
[root@localhost ~]# 详情
root: 当前登录的用户名
localhost: 主机名
~: 代表我当前所在的目录; 提示:可以输入pwd看到当前所在目录的全路径

#: 超级用户提示符
$: 普通用户的提示符

root 目录是root用户的家目录用符号~表示,普通用户的家目录是home; root不是根目录
-------------------
命令格式:

命令 [选项] [参数]
多个选项或多个参数可以写在一起
注意:个别命令使用不遵循这个原则,极少;

如: 
ls [选项] [文件目录]
选项: 
-a 显示所有的文件,包括影藏的(以.开头一般为系统文件,不是为了让人看不见)
-l 显示详细信息
-d 查看目录属性
-h 人性化显示文件大小
-i 显示inode
如果我们没有选择文件目录就是当前的文件目录

在输入ls后我们可以看见如:
-rw-r--r--.
drwxr-xr-x.
等这样的文件,一共是10位,第一位来区分文件-文件,d目录,l软链接文件,
后面3位一组:
rw-                       r--                    r--       
前3位为所有者(主人);中间3位所属组(组权限);最后3位为其他人(其它)
r读w写x执行

-----------------------
linux 的权限机制到底是怎么回事?
http://blog.csdn.net/vvcumt/article/details/38534379

Linux下权限有三种,用户权限(主人),组权限,其他用户;


一个文件被谁创建,那个用户就拥有用户权限;
我们可以通过修改文件权限,来完成对某些用户进行屏蔽,因为另一个用户属于其他用户
(对应上面的其他用户),当然我们可以让那个用户拥有和当前创建用户的组权限,从而达到
让其他用户也可以操作这个文件;多个用户可以来至一个组;


可以使用chmod filename 改变文件的权限;
可以使用chown filename 改变文件所属的用户和组
----------------------------

用户登录使用su- 切换管理员身份
shutdown -h now 关机
shutdown -r now 重启
reboot 重启
logout 用户注销
ls 显示文件
ls -l 显示文件的详细信息
-a 显示影藏文件 -l 显示长列表格式 ....其实有很多很多需要网上查;支持 组合 -al 

没有消息就是最好的消息,好事不出门,坏事传千里
cd 就是切换目录的
cd / 到根目录
dir 和is一样都可以显示当前目录
pwd 显示当前在哪个目录下
useradd 添加用户
passwd 设置密码 ,注意后面要是不写用户名,就是给当前用户设置.
userdel xiaoming 删除但保留文件夹
userdel -r xiaoming 删除及用户的文件夹(目录)
vi 编辑文件内容
cat 查看文件内容
wq 保存
cp a.out /home/xiaoming/ 复制a.out到后面这个目录
tab 可以补全代码
more 可以分页显示 
ls l /est/ | more
在linux 和unix 系统中 | 就是管道命令; 那上一个命令的结果交给 | 的后面的命令处理

grep -n "shunping" aaa.java 在aaa文件中 查找有没有shunping这个字符串 有提示在第几行
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
find  /root/ -name aaa.java 在root 下查名字 叫aaa.java 的文件
ls -l > a.txt 列表的内容写入到a.txt 中(没有自动创建,有覆盖)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
>> 是追加

++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++

Linux 上到底如何创建一个用户?

http://www.runoob.com/linux/linux-user-manage.html 
添加一个用户
useradd –d /usr/huang -m huang--新增一个huang的用户,自动创建目录;指定了该用户的家目录
把这个用户添加到一个组里
groupadd huang -- huang是组名

新建的用户,不修改密码是不能使用的
passwd huang -- 修改huang这个用户的密码

可能还使用了useradd -s huang;
经过了上面几步操作后,是远程可以使用这个用户登录的;且可以使用su huang 切换的
++++++++++++++++++++++++++++++++++++++++++
第二种方式:
groupadd users
建立一个新用户账户testuser1,并设置UID为544(1-500系统保留),
主目录为/usr/testuser1,属于users组:
代码如下
useradd -u 544 -d /usr/testuser1  -g users -m  testuser1
然后记得修改密码
++++++++++++++++++++++++++++++++++++++++++
chmod 777 用户名 //修改这个文件用户权限
chmod 777 文件名  //修改文件权限
777分别表示user,group及other的权限r=4,w=2,x=1

cat /etc/group //查看 linux中所有的组
cat /etc/passwd //查看linux 中所有用户信息
source /etc/group //刷新这个文件
----------------------------
linux 如果对某个用户的某个文件进行权限管理:
http://blog.csdn.net/qwq_qaq/article/details/54882203

setfacl -x u:userA -R /   #删除userA的所有权限
setfacl -m u:userA:rwx /dir1  #赋予userA对dir1的读写执行权限
setfacl -m u:userB:rwx /dir1  #赋予userB对dir1的rwx权限,
同理可以设置userB C D对dir2,3,4等等其它目录的权限
----------------------------------
-R: 递归设置子目录下的权限
setfacl -x u:username dir/file #删除用户的权限
setfacl -x g:groupname dir/file #删除组的权限
setfacl -b dir/file  #删除该目录的全部acl权限

------------------------------
# 安装yum包
yum install <package_name>
# 卸载yum包
yum remove <package_name>
# 安装rpm包
rpm -ivh <package_name>
# 卸载rpm包
rpm -e <package_name>
---------------------------
文件处理命令:
#创建目录:

创建目录: mkdir hjf; 创建多层目录:mkdir -p  hjf/ju/fei
创建文件: touch huang.txt //创建huang.txt一个文件
切换目录: cd 路径;
可以通过cd ../或cd /root/或cd ~或cd 回到根目录
切换到上一次操作的目录: cd -
切换到上一级目录: cd ..
清屏快捷键: ctr + l;
命令补全(忘记单词怎么拼全):ip 按两下tab键会自动提示全部关于ip开头的命名
pwd: 打印当前工作目录 ping word directory 的简写

#删除目录:

rmdir:只能删除空目录(极少使用),且只能删除目录;
rm (remove): 删除文件; rm -r:删除目录; rm -rf:删除目录且不询问;
使用特别小心,删除后找不回; 
rm -rf / 非常危险,相当删除c磁盘;
 
#复制命令: cp
 
-r:赋值目录
-p: 连带文件属性复制
-d: 若源文件是连接文件,则复制连接属性
-a: 相当于pdr
#举例
cp -a install.zip /opt 
#将当前文件的install.zip 文件复制到根目录下的opt目录下;


#剪切改名:
mv: 就算移动目录也不需要 -r参数
对于改名: mv test.log  newTest.log ,如果剪切都是在同一个目录下就是改名


#链接命令:
ln:硬链接
ln -s:软链接(推荐)
硬链接特征:
1,拥有相同i节点和存储block块,可以看做为同一个文件
2,只能通过i节点识别(可以理解为指针值);ls -i可以看到i节点
3,不能跨分区
4,不能针对目录使用

举例:
[root@localhost huang]# ls -il
总用量 56
267498 -rw-r--r--. 2 root root 24772 10月 16 2016 install.log
267498 -rw-r--r--. 2 root root 24772 10月 16 2016 newInstall.log

2 表示链接数; 267498 i节点号

软链接特征:
1,和windows快捷方式一样;使用使用创建软链接一定要写绝对路径
2,可以跨分区

[root@localhost ju]# ll -i
总用量 28
276265 -rw-r--r--. 2 root root 24788 4月  23 06:18 newInstall.log
276236 lrwxrwxrwx. 1 root root    14 4月  23 06:26 one.log -> newInstall.log

软链接以l开头, 且后面会指向源文件; i节点值和源文件不一样
-------------------------------
linux 环境变量

[root@huangjufei-Linux ~]# lll
-bash: lll: command not found -- 没有找到这个变量;linux去环境变量中逐个查找,如果都没找到就报错


[root@huangjufei-Linux ~]# echo $PATH -- 输出环境变量;
/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/root/bin

结论: 
所以我们自己安装的程序,需要到绝对路径下去执行;不然我们需要配置环境变量;
--------------------------------
#搜索功能:

1,locate:特点:数度快,只能按文件名搜索;不是实时更新(默认1天更新一次);
举例:
[root@huangjufei-Linux ~]# updatedb --手动强制更新
[root@huangjufei-Linux ~]# locate install.log.syslog 
/root/install.log.syslog

了解:搜索功能和一个/etc/updatedb.conf 配置文件密切相关;比如很多目录下不搜如:/temp,或很多后缀名不搜;


2,whereis:搜索命令搜索;
举例:
[root@localhost tmp]# whereis ls
ls: /bin/ls /usr/share/man/man1p/ls.1p.gz /usr/share/man/man1/ls.1.gz

后面是帮助文档所在位置;
whereis -b;不查看帮助文档位置 ;whereis -m;只查看帮助文档位置

[root@localhost tmp]# whatis ls --告诉你这个命令的作用
ls                   (1)  - list directory contents
ls                   (1p)  - list directory contents

3,which 搜索命令搜索;,可以查看到命令的别名;和whereis类似;
另 比如:liunx中@path来指定环境变量 和windows一样;
比如cmd 中执行mysql会在环境变量去找,找不到就报没有发现该命令!


4,find 非常,非常强大;参数多;
find [搜索范围] [搜索条件]
举例: 
[root@huangjufei-Linux ~]# find / -name install.log -- 在根路径开始按 名字 搜索 install.log这个文件;
/root/install.log
--------------------------------------
通过*搜索
[root@huangjufei-Linux ~]# find /root -name "install.log*" --通过/root缩小范围,我们还可以使用通配符;*任意;注意引号抱起来
/root/install.log.syslog
/root/install.log
--------------------------------------
通过?号匹配一个任意字符
[root@huangjufei-Linux usr]# touch adaa -- 创建一个文件名字叫adaa
[root@huangjufei-Linux usr]# ls -- 我创建了adaa,adb,adc 这样3个文件
adaa  adb  adc  bin  etc  games  include  lib  libexec  local  sbin  share  src  tmp
[root@huangjufei-Linux usr]# find /usr -name "ad?" -- 通过?号只匹配ad后面一个字母,adaa这个就是搜索不出来的
/usr/share/locale/ada
/usr/share/locale/ady
/usr/adb
/usr/adc
--------------------------------------
通过[],更为精确的搜索
[root@huangjufei-Linux usr]# find /usr -name "ad[a,b]" -- 只会匹配一个字母所以 adaa也是搜索不出来的;ady也是不会搜出来的
/usr/share/locale/ada
/usr/adb
---------------------------------------
[root@huangjufei-Linux usr]# find /usr -name "*aa" -- 常用,以aa结尾的文件;
/usr/share/locale/paa
/usr/adaa
---------------------------------------
-iname 不区分大小写;
find /root -user root;按照所有者搜索
find /root -nouser; 查到没有所有者的文件(即为垃圾文件);但proc和sys和内存相关的文件夹内容不要删除;
----------------------------------------

搜时间(了解):
find /var/log/ -mtime +10;查找10天前修改的文件;
atime 文件访问时间;ctime改变文件属性时间; mtime 修改文件内容;
-10 天内修改的文件;
10 10天当前修改的文件;

按文件大小(搜)(了解):
find /root -size 25k ;在root目录下搜索25M:注意大写,k是小写M是大写

还支持and,or(了解) 
find /etc -size +20k -a -size -50k;查找大于20且小于50k的文件;+是大于-是小于
o 是或;
但上面查出来看不到文件的大小,我们还用通过ls - lh 查看;所有我们可以使用下面语句:
find /etc -size +20k -a -size +50k -exec ls -lh {} \;
find -inum -exec rm -rf {} \; 找到后直接删除;
说明:-exec 相当于前面语句结果后的第二条语句;十分强大;


按i节点(就是文件id号)搜索(了解):
举例:
[root@huangjufei-Linux usr]# ls -i -- 查看i节点值
138176 adaa  138175 adc  131082 etc    131084 include  131095 libexec  131128 sbin   131682 src
138155 adb   131081 bin  131083 games  131085 lib      131096 local    131076 share  131685 tmp
[root@huangjufei-Linux usr]# find /usr -inum 138176 -- 按i节点搜索
/usr/adaa
--------------------------
搜索文件里的内容:
举例:
[root@huangjufei-Linux ~]# grep -i "attr-2*" install.log -- 在install.log这个文件中去查找attr-2的字符串;
Installing libattr-2.4.44-7.el6.i686
Installing attr-2.4.44-7.el6.i686
-----------------------
-i,不区分大小写 ; -v 就是结果取反;不支持通配符,需要正则表达式;
--------------------------------
ps -le|grep java -- 查看全部进程,再通过管道符给grep,再找出有java的记录,我们常用来查tomcat
rpm -qal |grep mysql 查看mysql所有安装包的文件存储位置
--------------------------
#帮助命令:
man (manual手册,指南的简写)
man ls;
man -f 相当于 whatis 命令;查看命令有哪些等级;
举例:
man -5 passwd;
man -4 null;
man -8 ifconfig;
默认打印等级1;一共有9个等级

#其他帮助:
ls --help 在xshell上可以看到中文帮助;
如何查看一个命令是内置命令还是后面添加的?
可以通过whereis 命令 如果有路径就是后来添加的;
如whereis ls 在/bin/ls 下而 whereis cd 看不到说明cd是shell内部命令;
shell就是壳和内核交互的软件;可以把字母命令翻译为2进制机器语言;
这时就有一个help cd 专门查看内部命令帮助文档; man 是看不到内部命令的帮助文档的;


详细帮组命令info(太详细不推荐,推荐man或 ls --help):
- 回车: 在进入帮助页面带*号标记处回车
-u:进入上层页面
-n:进入下一个帮组小节
-q:退出
---------------------------------------

#压缩和解压
zip格式可以在windows和linux上可以交互转换
#压缩文件格式(压解文件名需要跟上对应的压缩后缀,好维护):
zip 压缩文件名 源文件

#压缩目录格式:
zip -r 压缩文件名 源目录

#解压缩格式
unzip 文件名/或文件夹名


.gzip格式
#文件格式: 
gzip 源文件
注意:gzip压缩后源文件会消失;
#文件夹格式:
gzip -r 目录
注意:只会压缩子目录中,顶级没压缩
#我们可以通过这种复制方式来保留原文件(一般不用)
gzip -c 源文件 > 压缩文件

#解压
gzip -d 被压缩的文件名
gunzip 压缩的文件名

.bz2格式(不能压缩目录):
格式:
bzip2 源文件 #默认不保留源文件
bzip2 -k 源文件 保留源文件

#解压
bzip2 -d 压缩文件
bunzip2 -k 保留压缩文件


#打包命令tar
tar -cvf 打包文件名 源文件
-c: 打包
-v: 显示过程
-f: 指定打包后的文件名
#上面的.gzip和bzip2对目录的压缩都不友好,这时我们可以通过先tar才压缩;

#解压
tar -xvf 源tar包名;


注意:tar支持一次性打包并压缩;
j:对应的 bzip2 格式
z:对应的 gzip格式

tar -jcvf 新的文件名.tar.bzip2 源文件
tar -zcvf 新的文件名.tar.gzip 源文件

同时对多个文件压缩且到指定目录下举例:
tar -zcvf /opt/新的文件名.tar.gzip 源文件1 源文件2

#解压:
tar -jxvf 文件名.tar.bzip2
tar -zxvf 文件名.tar.gzip
#还可以指定压解路径
tar -zxvf 文件名.tar.gzip -C /opt 
通过-C 指定目录

-------------------------------------------
#开关机:
服务器最好不要高峰期关机;
shutdown [选项] 时间
-c:取消前一个关机命令
-h:关机
-r:重启

另外还有几个关机和重启命令,但没有shutdown安全
系统运行级别:
0关机;
1单用户;(和window中的安全模式)
2不完全多用户,不含nfs服务;
3完成多用户;(默认就是)
4未分配;
5图形界面;
6重启

使用:
init 0 就是关机;
init 6 就是重启;

可以通过runlevel查看当前的运行级别

#cat 命令查看文件内容,下面是查看当前用户启动时使用什么级别;
如果想启动默认到图形界面就修改配置文件中的值;但千万不要写0和6
cat /etc/inittab 

linux默认允许远程用户是256个,最大可以6W多个


#退出登录用户(好习惯)
logout

----------------------------------------
#挂载
挂载就是分配盘符,必须分配盘符后才可以使用;windows只是自动的;
#查看系统中已经挂载的设备
mount 
#依据配置文件/etc/fstab的内容,自动挂载
mount -a
--------------
#查看系统中登录了那些用户
w
jcpu:指和终端连接所有进程占用时间
pcpu: 当前进程占用时间;
what:当前运行的命令

#who 比w查看的功能少

#查看历史登录的用户,可以看到有黑客来过没
last

#查看所有用户的最后一次登录的时间
lastlog 

#查看当前使用的sell
echo $SHELL

linux(sh,ksh,bash,psh,zsh主要是bash)和unix(csh,tcsh)不同在与shell不同,但很多相通

-----------------------
#输出语句
echo 
#输出 hell回车o
echo -e "hell\no" 
使用 -e 支持转义;支持ASCII码
如: echo -e "\x68" 输出 h字母

--------------------------
liunx的第一个脚本
vim hello.sh
#!/bin/bash
#注释:这是我的第一个shell脚本
echo -e "\e[1m;36m 天上掉下个林妹妹 \e[0m"

调用:
bash hello.sh

赋予执行权限,直接运行
chmod 775 hello.sh
./hello.sh
通过
---------------
查看系统中以有的别名
alias 

#自定义别名(但只是写到内存中,如果长期要写到环境变量中)
alias lll='ls -lh --color=auto'

#写入环境变量配置文件
vi ~/.bashrc 

#删除别名
unalias

#不用重启让配置文件直接生效
source bashrc

#清屏
clear
ctrl + u 删除到首行
ctrl + z 把命令放入后台(不要随便用)
ctrl + a 光标移动到首行
ctrl + e 光标移动到尾行
ctrl + c 强制终止当前命令
-------------------------------------
#查看历史命令
history
保存在在家目录下 ls -a .bash_history可以看到这个文件,文件中的命令没有直接
使用history看到的全;
history -w 缓存和文件同步
history -c 清除历史操作

-----------------------
#查看文件
vi
vim --升级版
cat 
more 查看文件
搜索文件内容:
tail -n 50 catalina.out -- 查看最后50行
---------------------------
#输出重定向(把命令结果输出到文件中)

#会覆盖原有的
命令 > 文件 
#追加
命令 >> 文件

#会覆盖原有的错误的信息(注意没有空格)
命令 2>文件 
#追加错误(注意没有空格)
命令 2>>文件
sd 
#正常和错误都写到文件中
命令 >> 文件名 2>&1

#还有简洁的(推荐)
命令 &>>文件

#正确和错误分开存放(推荐)
命令>>文件1 2>>文件2
---------------------------
可以用来判断执行语句到底正确执行没
sdfs && echo yes || echo no

管道符
# |号前面的作为后面执行的对象;注意的后面的命令必须能操作命令1;
ls -l /etc | more 
#查看有哪些用户连接到linux上
netstat -an | grep ESTABLISHED
# 统计linux 上的在线人数
netstat -an | grep established | wc -l

established [??'st??bl????t] 确定的
++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++


linux 只有两种包:
1,源码包,
2,rpm(二进制包);原Red Hat Package Manager,现在是一个递归缩写

概念区别:
源码包开源的,免费的,可以自定义安装,效率高;
rpm是经过编译的,安装简单,数度快,可能收费

安装后的的区别:
源码包和rpm包最大区别:安装位置不同;rpm包不建议指定安装位置,安装目录到处都是;
源码包建议安装目录:/user/local/软件名,没有卸载命令,直接删除安装目录


#RPM安装(因为太麻烦一般通过yum自动安装)
rpm -ivh 包全名
选项:
-i (install) 安装
-v (verbose) 显示详细信息
-h (hash) 显示进度
-- nodeps 不检测依赖性(骗自己)

-q 查询
-p 查询未安装包的信息
-i 查询软件信息
#RPM包升级
rpm -Uvh 包全名
-U (upgrade) 升级
#RRM包卸载
rpm -e 包全名
#rmp 查询是否安装了包
rpm -q 包名
#查系统中安装了java没(是否使用rpm安装过)
rpm -qa | grep java 
#查询一个文件属于哪个包(但必须确实存在)
rpm -qf abc.conf
举例(记得使用绝对路径):
rpm -qf /bin/ls 
#检测文件 是否被修改(没有修改不会有提示)
rpm -V httped -- 这个命令一般是下载后立即使用,判断是否被人动了手脚
#如果linux下某个命令被删除了,可以通过源包中只提取需要的那个命令

rpm2cpio 包全名 | cpio -idv .文件绝对路径
举例:
rpm2cpio /mnt/cdrom/Packages/coreutils-8.4-19.e16.i686.rpm | cpio -idv ./bin/ls

--------------------------------------------
yum 在线安装,作用为了解决rpm依赖性
缺点:redhat要收费,centos不收费

------------------------------
yum 源文件位置(常用)
vi /etc/yum.repos.d/CentOs-Base.repo
现在来看看里面内容的基本含义:
[base]: 容器名称一定要放在[]中
name: 容器说明,随便写
mirrorlist:镜像站点
baseurl: 我们的yum源服务器地址.默认是CentOs官方的yum源服务器,
可以使用;但你要是觉得慢,可以改为你喜欢的yum源地址 百度:国内yum源的安装(163,阿里云,epel)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
enabled: 此容器是否生效,默认不写为生效;enable=0就是不生效;
gpgcheck: 如果是1指rpm数字证书生效,0不生效;
gppkey: 数字证书公钥文件保存位置.
---------------------------------
yum 在线安装,需要有网络,如果没有网yum 提供了光盘本地安装(了解)


#本地光盘就是这个linux安装光盘
G:\BaiduYunDownload\CentOS-6.3-i386-bin-DVD1.iso

1,挂载光盘
mount /dev/sr0 /mnt/cdrom


2,断开默认配置文件网络连接(使用本地光盘),可以修改配置文件enable=0;
但这种方式麻烦,可以使用修改文件名
mv CentOS-Base.repo CentOS-Base.repo.bak
#修改文件后缀,使其失效

3,让光盘的生效
vi /etc/yum.repos.d/CentOS-Media.repo
#进到光盘文件中,修改为:
name=CentOS-$releasever - Media
baseurl=file:///mnt/cdrom/
#        file:///media/cdrom/
#       file:///media/cdrecorder/
gpgcheck=1
enabled=1

#完成后使用
yum list
#看到使用的c6-media结尾的说明使用的本地光盘

优点: 安全性高,效率高,不需要网络
缺点: 版本旧;
--------------------------------------
#yum list 查询所有可用的软件包列表
#yum search 关键字(如:httped) 搜索服务器上关键字包

#安装(常用)
yum -y install 包名(yum命令,列外不需要包全名)
选项
-install 安装
-y 自动回答yes
例如:yum -y install gcc

#升级(常用)
yum -y update httpd
但一般不要去升级,升级可能会让你停止服务;
yum -y update 
升级linux全部软件包,包含内核,可能洗白linux;不要用
yum -y upgrade 
升级所有包,不改变软件设置和系统设置,系统版本升级,内核不改变
------------------------
#卸载
yum -y remove 包名
也是慎用;
----------------------------
#yum 提供了组包安装

#查看有哪些组包(在xshell中看到全是中文,直接在linux上是英文)
yum grouplist 

通过在xshell 上设置查看语言
#临时使用中文查看
LANG=zh_CN.utf8
#临时使用英文查看
LANG=en_US

#安装组包,组名由grouplist查询出来
yum groupinstall 软件组名

举例:
yum groupinstall "Chinese Support" --安装中文支持的组包

#卸载组包
yum groupremove 组名
----------------------------
rpm 包的安装位置由作者指定,用户一般不指定;源码包则不一样

一般是下面的规则(现实由作者决定):
/etc/ 配置文件安装目录
/usr/bin/ 可执行的命令安装目录
/usr/lib/ 程序使用的函数库保存位置
/usr/share/doc/ 基本的软件使用手册保存位置
/usr/share/man/ 帮助文件保存位置


源码包我们一定要指定目录(方便删除):
一般放在/usr/local/软件名


由于安装位置的不同带来的影响:
rpm 包可以使用系统服务管理命令(service)来管理:
例如启动apache:
/etc/rc.d/init.d/httpd start
service httpd start
#service 其实是找的/etc/rc.d/init.d 这个;

源码包只能在源目录下去启动;但我们可以去init.d文件中去配置后是可以的;
-------------------------
如何上传文件到linux上?
可以使用winSCP ,xshell
一台linux上可以同时安装源码包和rpm包,但只能启动一个,因为端口会冲突;

+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++


linux 查看进程的常用3个命令:
ps aux --查看全部进程
ps -le --查看全部进程,PRI值cpu线程优先级,数值越低优先级越高
pstree -- 查看进程树
top	-- 查看linux的健康状态,默认按cpu使用率排序;主要看内存,swap,cpu 使用和空闲buffer(作用于写),cached(作用于读)

linux 杀死进程:

kill -9 PID -- 杀死单个(-9标识不管任何情况杀死该进程)
pkill -9 -t 终端号 -- 按照终端号剔除用户,不会提到自己
w -- 查看当前linux一共登录了那些用户,可以看到终端号
killall 进程名 -- 只要名字带这个进程名的全部杀死

+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++
和后台相关:
为什么需要在后台运行?
因为会挡住界面,不能输入其他命令,注意后台运行是绑定终端的,(每个登录用户都有一个终端),
反过来说你关闭终端也会关闭后台程序,注意;除mysql外;
jobs -l -- 查看后台运行的程序;

如何让程序在后台运行,直接在命令后面加&即可;不要把和用户交互命令在后台运行,如vi

举例2种方式:
top & -- 后台运行ls;后台运行
通过jobs -l查看在后台运行的程序
如: 
[root@huangjufei-Linux /]# jobs -l
[1]-  1599 Stopped (tty output)    top
Stoped 说明程序是关闭的,因为top属于用户交互命令;工作中可以使用cp 这种命令可以放后台使用

另: 执行top 运行后再执行ctrl+z,只是让程序暂停在后台,并不是后台执行;这样久而久之
后台会卡住很多程序,导致系统很卡;不建议使用;

如何让后台程序再回到前台运行?
fg %工作号 -- 工作号可以jobs -l 看到如上面的1
bg %1 -- 恢复到后台运行,%是可以不要的


nohup 命令 & -- 前面讲到后台程序和终端是绑定的,nohup的作用就是不绑定终端,
这样就算关闭终端,程序依然在运行

但这样我们每次开机都要手动去执行,还有开机就直接执行的方法;
vi /etc/rc.local --编译这个文件

+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++


查看系统资源使用情况
vmstat 1 3 查看cpu,内存,磁盘使用情况;每秒执行一次,一共执行3次

dmesg | grep CPU -- 查看系统内核的一些信息

free -m -- 专门看内存使用情况的命令

查看内核信息,2.6.32就是内核版本号,内核版本被各个企业包装为各种发行版本;
我的就是centos6.3发行版本
[root@huangjufei-Linux ~]#  uname -a
Linux huangjufei-Linux 2.6.32-279.el6.i686 #1 SMP Fri Jun 22 10:59:55 UTC 2012 i686 i686 i386 GNU/Linux

查看操作系统的位数
[root@huangjufei-Linux ~]# file /bin/ls
/bin/ls: ELF 32-bit LSB executable, Intel 80386, version 1 (SYSV), dynamically linked (uses shared libs), for GNU/Linux 2.6.18, stripped

+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++

搭建java 服务器

一,安装jdk

1,下载jdk,记得和查看linux 是32还是64位
(2)下载完成后放到自定义的目录下面并解压:tar -xvf jdk-8u91-linux-x64.gz
(3)然后可以删掉下载的压缩包:rm -rf jdk-8u91-linux-x64.gz
(4)进入jdk目录,记下当前目录:pwd
(5)添加环境变量:vim /etc/profile
export JAVA_HOME=/usr/local/software/jdk/jdk1.8.0_131
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar 
#保存退出命令 
java -version
#查看jdk 安装好没

-------------------------------------------
二,然后安装tomcat,不分32位

直接压解就可以访问
http://192.168.1.105:8080/

三,linux下使用yum安装mysql
 http://blog.csdn.net/a695017449/article/details/37900131
1,安装
查看有没有安装过:
          yum list installed mysql*
          rpm -qa | grep mysql*
 
查看有没有安装包:
          yum list mysql*
 
安装mysql客户端:
          yum install mysql
 
安装mysql 服务器端:
          yum install mysql-server
 
          yum install mysql-devel
  www.2cto.com  
2,启动&&停止
 
数据库字符集设置
          mysql配置文件/etc/my.cnf中加入default-character-set=utf8
 
启动mysql服务:
          service mysqld start或者/etc/init.d/mysqld start
开机启动:
          chkconfig -add mysqld,查看开机启动设置是否成功chkconfig --list | grep mysql*
 
          mysqld             0:关闭    1:关闭    2:启用    3:启用    4:启用    5:启用    6:关闭
停止:
          service mysqld stop
2,登录
 
创建root管理员:
          mysqladmin -u root password 123456
  www.2cto.com  
登录:
          mysql -u root -p输入密码即可.
忘记密码:
          service mysqld stop
 
          mysqld_safe --user=root --skip-grant-tables
 
          mysql -u root
 
          use mysql
 
          update user set password=password("new_pass") where user="root";
 
          flush privileges;  
 
3,远程访问
 
开放防火墙的端口号
mysql增加权限:mysql库中的user表新增一条记录host为“%”,user为“root”.
4,Linux MySQL的几个重要目录
  www.2cto.com  
数据库目录
         /var/lib/mysql/
配置文件
         /usr/share /mysql(mysql.server命令及配置文件)
相关命令
         /usr/bin(mysqladmin mysqldump等命令)
启动脚本
         /etc/rc.d/init.d/(启动脚本文件MySQL的目录)
卸载mysql
yum -y remove mysql*
如果是rpm安装的话:
rpm -e mysql
-------------------navicat 连接权限错误提示1130------------
mysql -u root -p  
mysql;use mysql;  
mysql;select 'host' from user where user='root';  
mysql;update user set host = '%' where user ='root';  
mysql;flush privileges;  
mysql;select 'host'   from user where user='root'; 

------------------------------------------------------

如何查看liunx下桥接ip
1,首先确定连接必须设置为桥接的方式.
2,键入ifup eth0
3,重启一下系统或者过一段时间等系统更新
4,键入ifconfig 看到inet Address发生改变了,不在是127.0.0.1
5,再使用Xshell连接即可
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
linux 下 ifcfg-eth0 配置 

网络接口配置文件 [root@localhost ~]# cat /etc/sysconfig/network-scripts/ifcfg-eth0 
# Intel Corporation 82545EM Gigabit Ethernet Controller (Copper) 
TYPE=Ethernet #网卡类型 
DEVICE=eth0 #网卡接口名称 
ONBOOT=yes #系统启动时是否自动加载 
BOOTPROTO=static #启用地址协议 --static:静态协议 --bootp协议 --dhcp协议 
IPADDR=192.168.1.11 #网卡IP地址 
NETMASK=255.255.255.0 #网卡网络地址 
GATEWAY=192.168.1.1 #网卡网关地址 
DNS1=10.203.104.41 #网卡DNS地址 
HWADDR=00:0C:29:13:5D:74 #网卡设备MAC地址 
BROADCAST=192.168.1.255 #网卡广播地址 
重新导入ifcfg-eth0网络配置文件 
[root@localhost ~]# /etc/init.d/network reload 
Shutting down interface eth0: [ OK ] 
Shutting down loopback interface: [ OK ] 
Bringing up loopback interface: [ OK ] 
Bringing up interface eth0: [ OK ] 
网卡接口关闭与激活 
[root@localhost ~]# ifdown eth0 #关闭网络 
[root@localhost ~]# ifup eth0 #启动网络 
网络服务启动与关闭 
方法一: [root@localhost ~]# service network stop #关闭网络服务 
[root@localhost ~]# service network start #启动网络服务 
[root@localhost ~]# service network restart #重启网络服务 
方法二: [root@localhost ~]# /etc/init.d/network stop 
[root@localhost ~]# /etc/init.d/network start 
[root@localhost ~]# /etc/init.d/network restart 网卡状态查询 
[root@localhost ~]# service network status 
Configured devices: lo eth0 
Currently active devices: lo eth0 
临时配置网卡信息,无需重启. 
[root@localhost ~]# ifconfig eth0 10.1.1.10 netmask 255.0.0.0 
查看网卡接口信息,默认列出所有接口 
[root@localhost ~]# ifconfig 
eth0 Link encap:Ethernet HWaddr 00:0C:29:13:5D:74 
inet addr:192.168.1.11 Bcast:192.168.1.255 Mask:255.255.255.0 
inet6 addr: fe80::20c:29ff:fe13:5d74/64 Scope:Link 
UP BROADCAST RUNNING MULTICAST MTU:1500 Metric:1 
RX packets:413 errors:0 dropped:0 overruns:0 frame:0 
TX packets:572 errors:0 dropped:0 overruns:0 carrier:0 
collisions:0 txqueuelen:1000 RX bytes:47701 (46.5 KiB) 
TX bytes:64842 (63.3 KiB) Base address:0x2000
Memory:d8920000-d8940000 
lo 
Link encap:Local Loopback 
inet addr:127.0.0.1 
Mask:255.0.0.0 
inet6 addr:::1/128 Scope:Host UP LOOPBACK RUNNING MTU:16436 Metric:1 
RX packets:407 errors:0 dropped:0 overruns:0 frame:0 
TX packets:407 errors:0 dropped:0 overruns:0 carrier:0 
collisions:0 txqueuelen:0 RX bytes:70759 (69.1 KiB) 
TX bytes:70759 (69.1 KiB) 
查看当前路由及网关信息 
[root@localhost ~]# netstat -r 
Kernel IP routing table 
Destination Gateway Genmask Flags MSS Window irtt Iface 
192.168.1.0 * 255.255.255.0 U 0 0 0 eth0 
169.254.0.0 * 255.255.0.0 U 0 0 0 eth0 default 192.168.1.1 0.0.0.0 UG 0 0 0 eth0

DNS:
主机名:CentOS
主DNS:202.106.46.151
第二DNS:202.106.0.20
第三DNS:8.8.8.8

网络配置:
eth0
静态ip:192.168.1.106
子网掩码        255.255.255.0
默认网关 IP     192.168.1.1


DEVICE=eth0
IPADDR=192.168.1.106
NETMASK=255.255.255.0
BROADCAST=192.168.1.255
ONBOOT=yes
BOOTPROTO=none
GATEWAY=192.168.1.1
TYPE=Ethernet
"/etc/sysconfig/network-scripts/ifcfg-eth0" 11L, 187C

--------------------------------------------------------------------------

linux 下配置jdk 环境变量:
vim /etc/profile

export JAVA_HOME=/usr/local/software/jdk/jdk1.8.0_131
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

让配置文件生效:
source /etc/profile

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
三国演义
第一集
黄巾起义,当时皇帝兵力不足,让各个区自己守城;这样的结果就是后期各个区会自立
为王,群雄争霸的局面马上就会出现;刘备看到了这种局面才有了召集关羽和张飞后续之事;
乱世造英雄,古代一个甲子60年一般就是最有可能出现乱世的局面
----
关羽取肉,自己不要一份,全部分给老百姓;这种品质最后导致关羽一直被祭拜的原因.
---
刘备卖草席,关羽卖绿豆,天空突然下雨的情况下才把他们聚到张飞家中;天时很重要
所以有时,你需要创造这种天时
---
张飞试探关羽功夫,故意捏碎关羽绿豆激怒关羽后,才知道关羽是否有真功夫!
如果不用这种方法,关羽是不会给张飞交手的
---
刘备劝架时第一句话就是先夸奖两位,这样才同时打消张飞和关羽的对刘备的防范;
中国人不管你做什么,主要看你的立场是否和我一致;
---
刘备故意说话慢吞吞,就是为了让关羽和张飞相信,如果一来就开口说出身份,别人
会怀疑,且别人会解决你神经病;中国人不会对不熟的人敞开心扉,所以为什么很多事情要
在酒桌上谈;
---
　　“谋定而后动,知止而有得”意即:在做事之前,先考虑清楚做这件事的后果和过程,
然后再去做;懂得何时停止行动,会有不错的收获或者所得;
-------
刘备刚得到的县令,督邮就来索要钱财被张飞毒打后辞职了.
---
督邮对刘备说大树底下好乘凉等一些话暗示刘备出钱,从中开出中国从古到今都是
腐败问题都存在;官比老百姓有钱;当官要找靠山,打工要找大公司,这样相对来说没
那么累;
---
由于刘备说没钱,督邮通过 ”贼咬一口,入骨三分“,意思是指被坏人诬陷,难以辩白,受害极深;
在城中贴告示,让百姓举报刘备;这样的目的就是为了敛财;有些官员被起底都和这种有关
---
张飞在家中要去打督邮但被关羽拦住,但最后张飞在外面还是打了督邮;
关羽在外面没有说张飞是一致对外的;兄弟之间在外面要一致对外,什么事回家里在说
---
当他们3人结义后,在外面时都是由大哥先发话
+++++++++++++++++++++++++++++++++++++++++
第二集
汉灵帝刘宏死后留下两个儿子刘辩和刘协,刘辩大5岁;还有一个妻子何皇后和董太后;
古代女人要么依赖儿子要么依赖丈夫,何太后想让自己的儿子做皇帝,董太后想刘协
做皇帝,两个女人有相同的处境却有不同的目标这时就出现2个婆媳对干的局面;
婆媳两个女人都是没有血缘关系的人,他们的存在都是通过丈夫或儿子产生的关系,所以
当儿子和丈夫死后他们的关系基本就不复存在了;
后宫大部分事情都需要宦官打理,这时就出现10常侍在2个女人之间的选择.何皇后把自己的
哥哥大将军何进安排进宫顺利的让刘辩上位做了皇帝;何进性格非常鲁莽,不停曹操的建议
独自入宫结果被10常侍杀了;说明当时宦官直接干于朝政;
曹操建议何进意见时,何进反而说曹操是宦官之后,这种狠话都是一把回头箭,早晚会伤到自己,
所以无关怎么样别人最痛的点不要要提及;就算别人的建议你不采纳也不要马上回怼;何进死就在于
狂妄自大;

何皇后找董太后协商时,董太后说"难道你还刚杀我不成"这种话是不能说的,这种话可能让对方原本没有这个
想法的人就又了这样的想法,最后让董太后心想事成;
何皇后先是让董太后还乡然后通过赏识毒酒赐死董太后;这样2步走作用非常大;首先让你实力大减,
(其实一般出皇宫就意味着死,一般都会派人监视,就是所谓的软禁)然后在乡下了,没人知道;
中国历来都是斩草除根;不然后人一定毕生目标就是报仇;

最后10常侍杀死何进之后相当于就是挟持皇帝谋反,皇帝外逃被董卓救后;董卓为了让自己的势力提升,就
需要改变原有路线,所以又让刘协做了皇帝;这个法则也是从古到今没变的;

何太后和何进2个人最后都没好下场,就是因为何太后简单的认为外面的事,和何进简单的认为后宫的事,
所以家庭还是需要分工合作,女人往往主内比男人更好;不适合处理外面的事情,因为外面的世界她往往接触得
太少;
+++++++++++++++++++++++++++++++++++++++++
第三集


李肃通过分析武将吕布差一坐骑,武将3样装备不能少(兵器盔甲坐骑);然后带上赤兔马和财物去策反吕布,
把董卓说得是顺先帝之意,刘辩无能;众臣不敢说,只是为了自己官职,而董卓敢于说出来了,还说何皇后杀死
皇太后等一些话让吕布动心;吕布动心后自己主动杀自己第一个义父丁原,后投靠董卓又拜董卓为义父;
这种无德之人董卓也敢要,最后下场何丁原一样;现在公司只看中能力,不看重品德;最后这些有能力的人
就可以是公司被策反之人;

董卓得到吕布后又找群臣吃饭,说要让刘协当皇帝之事;这种饭,说完你不反对就是同意的意思;中国人不需要说
太多,各个心知肚明;如果当时反对可能会被杀,如果事后反对也是很不好的.这种饭就是很难吃的;
董卓成功的让刘协登基后,刘辩被贬为藩王;何皇后自杀;

董卓通过废旧立新让刘协登基,主要目的就是让自己官职高升;但这种人往往后面都会暴死,因为群臣都不喜欢他.

一件事情可以顺取也可以逆取,但最后都必须顺守;董卓就属于后者但往往得到权力的人都会为所欲为,不知道顺守;

+++++++++++++++++++++++++++++++++++++++++
第四集

王允假做寿邀请众臣商量讨伐董卓,这样才可以避开董卓的眼线,是为了保护自己和众臣.
曹操献计"亲信之人防不胜防"

曹操正在刺杀董卓时还是被卢布岔开了,曹操马上随机应变说自己是来献七星宝刀给董卓的,然后保持镇定
得骑试宝马逃跑了;

吕布和董卓等曹操逃跑后才觉得不对,李儒献计董卓 "请曹操在来府上,如果来就是真献宝刀,不然就是刺杀";

曹操跑到陈宫县内,被手下的人捉住;陈宫说"此人确有几分相识",没有选择上交曹操换取大量财物,
或直接放走曹操,而是选择了暂时关押曹操;然后在夜里突然喊曹操当时把曹操吓了一跳,这样陈宫肯定他就是曹操
,陈宫想跟一个明主做大事,和曹操几番交谈后弃官随曹操一起逃跑,后来到曹操爹的熟人吕伯奢家中.

吕伯奢说"现在到处都在抓你,你犯了什么事",后又说出门去打好酒,曹操在梦里被
外面的磨刀声音惊醒后想起吕伯奢白天的举动,就杀了全家包含妇女小孩;后进入厨房才发现是杀猪要款待曹操
,曹操又继续逃跑,在路上又遇到买酒回家的吕伯奢,本来曹操不打算杀他的,但吕伯奢说"你身上怎么有血"这样曹操
知道以后无法隐瞒了又把吕伯奢杀了,陈宫心情低入谷底问曹操为何;曹操说"宁教我负天下人,休教天下人负我",
后陈宫决定不再跟随曹操,他们分开逃跑了.从这里可以看出在很敏感的话题要小心,不然就引来大祸.

+++++++++++++++++++++++++++++++++++++++++
第五集
团结就是力量
袁绍召集的18路兵马进攻洛阳,准备讨伐董卓;但这种临时召集的团队,虽然人多但各个心怀鬼胎;
比如孙坚就要拿下洛阳时,袁术怕他独自得到功绩就不发粮草,导致孙坚失败;

华雄再连斩袁绍多名大将的情况下,关羽温酒斩华雄;曹操当时就看上了关羽;
吕布一人同时战张飞,关羽,刘备3人都没分出胜负,可见吕布功夫了得,董卓怕吕布吃亏,鸣金收兵保
吕布;因为吕布是董卓手下的核心武将;后李儒建议董卓迁都长安;因为长安之地西汉东汉延续了很多代.
在董卓迁都时,曹操要袁绍追击董卓;袁绍没有同意,把曹操气惨了;
++++++++++++++++++++++++++++++++++++++++++
第六集

人与人之间平时最好有些交情,不然有事之时就吃亏;
比如曹操带兵去追击董卓结果被埋伏,打了败仗;但袁绍还摆酒席给曹操压压惊,说"胜败乃兵家常事"
还有一般是常常打败仗的人,会取得最后的胜利;曹操就是一个例子;

王允有个养女叫貂蝉,芳年16;王允先是表现出焦虑后被貂蝉发现,在貂蝉叹气时,王允责骂貂蝉,貂蝉解释,
说愿为主人献出生命,这种情况下;王允才告诉貂蝉连环计;"先许配貂蝉给吕布,然后在嫁给董卓,离间他们",
让吕布杀董卓;王允当时叩拜貂蝉几次;貂蝉也保证不说出王允的计策,因为这是灭门之灾;王允邀董卓到家中
商量国事,又献歌妓貂蝉28岁给董卓;

演戏和撒谎是不一样的;
王允演戏告诉吕布,是董卓说事今晚要去王允家做客,然后问家中有一女要许配给自己的义子;让此女出来看看,
然后说今日就是良日先把此女接回府上准备给自己义子;这样一说让吕布还以为董卓也在为自己着想;结果后来
发现董卓已和貂蝉睡一起了;所以非常生气;后吕布又找貂蝉核对事情,貂蝉又选后园和吕布约见,又诉苦,还要
已死来证明自己的清白;在亲热之时又让董卓看见;一系列的连环计让吕布和董卓都想杀了对方;貂蝉在两边都
以死来欺骗吕布和董卓;

但当时李儒告诉董卓"貂蝉只是一个普通女子,而吕布是董卓称王的必要因数",董卓还是恍然大悟,准备许配貂蝉
给吕布,好让吕布对自己死心塌地;问貂蝉意见时,貂蝉又已死不愿意;

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
歌单:

广岛之恋,盛夏的果实,断点,当你老了,至少还有你,有没有人告诉你,黄昏,恋上一个人,西海情歌,过火,同桌的你

王杰:一场游戏一场梦

陈晓东:突然心动,心有独钟,比我幸福

陈奕迅:因为爱情,好久不见,十年,爱情转移,

无印良品:别人都说我们会分开,是你变了吗,掌心,想见你,伤心地铁

齐秦:无情的雨无情的你,夜夜夜夜,大约在冬季,外面的世界,不让我的眼泪陪我过夜,

阿杜:天黑,坚持到底,他一定很爱你,离别,撕夜,安妮,

陶喆:下沙,普通朋友,找自己,爱我还是他,就是爱你,爱,很简单,流沙,月亮代表我的心

周杰伦:最后战役,上海一九四三,黑色幽默,回到过去,星晴,开不了口,龙卷风,反方向的钟,分裂,屋顶,暗号,可爱女人,轨迹,借口,安静

任贤齐:花太香,小雪,只爱你一个人,爱的路上只有我和你,老地方,依赖,哭个痛快,春天花会开,星语心愿,我是一只鱼,天涯,桥边姑娘,流着泪的你脸,人不该让男人太累,天使也一样,一个男人的眼泪,伤心太平洋,死不了,还有我,一个人,心肝宝贝,任逍遥

黎明:爱情影画戏,我可以忘记你,对不起,我爱你,两个人的烟火,哪有一个天不想你,今夜你会不会来,兄弟,深秋的黎明,

张学友:心碎了无痕,我真的受伤了,我等到花儿也谢了,情网,吻别,一千个伤心的理由,寂寞的男人,明日世界终结时,

陈小春:离不开你,没那种命,我爱的人,独家记忆,一定要幸福

迪克牛仔:我可以抱你吗,爱无罪,三万英尺,有多少爱可以重来,放手去爱,爱我的人和我爱的人,你知道我再等你吗,值得,梦醒时分,我这个你不爱的人,

威尼斯的泪,你是我最深爱的人,每次都想呼喊你的名字,
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

游戏下载:

https://down.ali213.net/pcgame/all/0-0-0-jingdian-hot-pic-3