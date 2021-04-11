package org.amr.reflection;

/**
 * @author : AMRS
 * @CreateDate : 10-Apr-2021 (Sat) (3:06 PM)
 * @ProjectName : ReflectionInJava
 */

public class UserOperations{


    private String messageBuilderWithUser(String message,Integer userId) {
        String totalMessage = "";
        totalMessage+=updateDetails(userId);
        totalMessage = totalMessage + message;
        return totalMessage;

    }

    private String updateDetails(Integer userId){
        String message = "";
        if(userId>0){
            message+="Hi, Mahendra\n";
        }
        return message;
    }

}
