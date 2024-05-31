
package Controller.SupportFunction;

import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.impl.regex.REUtil;

public class SplitUsageNum {
    public List<Integer>getListUsage(int num){
        List<Integer>result=new ArrayList<>();
        if(num<0){
            return null;
        }else if(num>=0 && num<=50){
            result.add(num);
            return result;
        }else if(num>50 && num<=100){
            result.add(50);
            result.add(num-50);
            return result;
        }else if(num>100 && num <=200){
            result.add(50);
            result.add(50);
            result.add(num-100);
            return result;
        }else if(num>200 && num<=300){
            result.add(50);
            result.add(50);
            result.add(100);
            result.add(num-200);
            return result;
        }else if(num>300 && num<=400){
            result.add(50);
            result.add(50);
            result.add(100);
            result.add(100);
            result.add(num-300);
            return result;
        }else{
            result.add(50);
            result.add(50);
            result.add(100);
            result.add(100);
            result.add(100);
            result.add(num-400);
            return result;
        }
    }
    public int caculateLevel(int usage){
        if(0<usage&&usage<=50){
            return 1;
        }else if(50<usage&&usage<=100){
            return 2;
        }else if(100<usage&&usage<=200){
            return 3;
        }else if(200<usage&&usage<=300){
            return 4;
        }else if(300<usage&&usage<=400){
            return 5;
        }else{
            return 6;
        }
    }
}
