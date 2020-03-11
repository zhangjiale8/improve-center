package com.zjl.javase.designModel.state;

public class Car {
	 //0：Park驻车档，1：Reverse倒退挡，
     //2：Neutral空挡，3：Drive前进档。
     String state = "P";//初始状态是P档
 
     public void push(){//向上推档杆
         switch (state) {
         case "P"://驻车档状态
             System.out.println("WARN!!!到头了推不动了！");
            break;
        case "R"://倒挡状态
            state = "P";
            System.out.println("OK...切P档");
            break;
        case "N"://空档状态
            System.out.println("OK...切R档");
            break;
        case "D"://前进档状态
            System.out.println("OK...切N档");
            break;
        default:
            break;
        }
    }

    public void pull(){//向下拉档杆
        //这里省略，逻辑同上类似
    }
}
