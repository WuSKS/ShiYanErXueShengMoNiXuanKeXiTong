# 实验二学生选课模拟系统
## 一、实验目的
<br>初步了解分析系统需求，从学生选课角度了解系统中的实体及其关系，学会定义类中的属性以及方法；<br>掌握面向对象的类设计方法（属性、方法）；<br>掌握通过构造方法实例化对象；
## 二、业务要求
<br>学校人员分为“教师”和“学生”，教师教授“课程”，学生选择“课程”。初期为了设计简单，每名教师讲1门课程，每名学生选1门课程。
<br>对象:教师（编号、姓名、性别、所授课程）
     <br>学生（编号、姓名、性别、所选课程）
     <br>课程（编号、课程名称、上课地点、时间）
## 三、实验要求
1.编写上述实体类以及测试主类
<br>2.在测试主类中，实例化多个类实体，模拟<br>1）教师开设某课；<br>2）学生选课、退课<br>3）打印学生课表信息（包括：编号、课程名称、上课地点、时间、授课教师
## 四、解题思路
首先定义四个类，分别为Teachers类、Students类、Course类、Test类
<br>1.Students类：
<br>Students类表示学生对象，具有学号、姓名、性别和所选课程等属性。
构造方法`public Students(int num, String name, String gender)`用于初始化学生对象的属性。
<br>`selectCourse(Course course)`方法用于学生选择课程，将课程对象赋值给学生对象的course属性。
<br>`dropCourse()`方法用于学生退选课程，将课程对象从学生对象的course属性中移除。
<br>`getCourse()`方法用于获取学生所选的课程对象。
<br>`getnum()`方法用于获取学生的姓名。
<br>2.Teachers类：
<br>Teachers类表示教师对象，具有教师编号、姓名、性别和所授课程等属性。
<br>构造方法`public Teachers(int num, String Name, String gender, Course course)`用于初始化教师对象的属性。
<br>3.Course类：
<br>Course类表示课程对象，具有课程编号、课程名称、上课地点和上课时间等属性。
<br>构造方法`public Course(int num, String courseName, String location, String time)`用于初始化课程对象的属性。
<br>`gteacher(Teachers teacher)`方法用于将教师对象赋值给课程对象的teacher属性。
<br>4.Test类：
<br>Test类为测试类，主要用于测试学生选课和退课的功能。
<br>在main方法中，首先实例化三个课程对象和三个教师对象，然后实例化两个学生对象。
<br>通过调用课程对象的`gteacher(Teachers teacher)`方法，将教师对象赋值给课程对象的teacher属性。
<br>学生对象通过调用`selectCourse(Course course)`方法选择课程，将课程对象赋值给学生对象的course属性。
<br>通过调用`printCourseInfo(Students student)`方法打印学生的课表信息。
<br>学生对象通过调用`dropCourse()`方法进行退课，然后再次选择不同的课程。
<br>再次通过调用`printCourseInfo(Students student)`方法打印更新后的学生课表信息。
## 五、关键代码
printCourseInfo方法对实例化的学生的退选课进行判断并打印而课表信息
```Java
public static void printCourseInfo(Students student) {
        if (student.getCourse() != null) {
            System.out.println(student.getnum() + "\t" + student.getCourse().getCourseName() + "\t" +
                    student.getCourse().getLocation() + "\t" + student.getCourse().getTime() +
                    "\t" + student.getCourse().teacher.Name);
        } else {
            System.out.println(student.getnum() + "\t未选课\t-\t-\t-");
        }
    }
```
在Test类中，通过实例化课程对象、教师对象和学生对象，并相互调用方法来实现选课和退课的功能。
通过调用printCourseInfo方法来打印学生的课表信息。
```Java
public static void main(String[] args) {
        // 实例化课程对象
        Course course1 = new Course(1, "\t线性代数                   ", "\t综合教学楼102", "\t周一 13:30-15:10");
        Course course2 = new Course(2, "\tJava应用开发技术", "\t综合教学楼305", "\t周四 15:30-17:10");
        Course course3 = new Course(3, "\t大学物理                   ", "\t主楼3402   ", "\t周四 10:00-11:40");
        
        // 实例化教师对象
        Teachers teacher1 = new Teachers(1, "王老师", "女", course1);
        Teachers teacher2 = new Teachers(2, "张老师", "男", course2);
        Teachers teacher3 = new Teachers(3, "谭老师", "男", course3);
        
        // 实例化学生对象
        Students student1 = new Students(1, "小明", "男");
        Students student2 = new Students(2, "小红", "女");
        
        //建立棵程和教师的联系
        course1.gteacher(teacher1);
        course2.gteacher(teacher2);
        course3.gteacher(teacher3);
        
        
        // 学生选课
        student1.selectCourse(course1);
        student2.selectCourse(course2);
        
        // 打印学生课表信息
        System.out.println("学生课表信息：");
        System.out.println("\t编号\t课程名称\t\t上课地点\t\t时间\t\t\t授课教师和授课时间地点");
        printCourseInfo(student1);
        printCourseInfo(student2);
        
        // 学生退课
        student1.dropCourse();
        student2.dropCourse();
        
        //学生再选课
        student1.selectCourse(course2);
        student2.selectCourse(course3);
        
        // 打印学生课表信息
        System.out.println("\n学生退选课后的课表信息：");
        System.out.println("\t编号\t课程名称\t\t上课地点\t\t时间\t\t\t授课教师和授课时间地点");
        printCourseInfo(student1);
        printCourseInfo(student2);
    }
```
## 六、运行结果截图
<img width="1280" alt="image" src="https://github.com/WuSKS/ShiYanErXueShengMoNiXuanKeXiTong/assets/145275222/ad9afbed-fc50-4dd1-a61a-9593d4e537b3">

## 七、感想与体会
通过这次综合性选课实验，加深了我对面性对象设计，理清了学生选课过程业务逻辑关系，编写的程序会存在很多bug，需要使用异常处理机制使程序更加健壮，错误相对容易发现，防止系统崩溃。 最后，也希望更加深入地去学习java的其它内容，提高自己的编程与逻辑分析能力，感谢老师的辛勤付出，谢谢您。 
