package XuanKe;

public class Test {
	
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
        
        student1.selectCourse(course2);
        student2.selectCourse(course3);
        
        // 打印学生课表信息
        System.out.println("\n学生退选课后的课表信息：");
        System.out.println("\t编号\t课程名称\t\t上课地点\t\t时间\t\t\t授课教师和授课时间地点");
        printCourseInfo(student1);
        printCourseInfo(student2);
    }
	public static void printCourseInfo(Students student) {
        if (student.getCourse() != null) {
            System.out.println(student.getnum() + "\t" + student.getCourse().getCourseName() + "\t" +
                    student.getCourse().getLocation() + "\t" + student.getCourse().getTime() +
                    "\t" + student.getCourse().teacher.Name);
        } else {
            System.out.println(student.getnum() + "\t未选课\t-\t-\t-");
        }
    }
}
    
    
