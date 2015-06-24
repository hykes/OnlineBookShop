package cn.jxufe.core.util;

import java.security.MessageDigest;  

/**  
 *  
* 类名称：CipherUtil   
* 类描述： 对数据进行16位的Md5加密
* 创建人：Jxufe HeHaiYang
* 创建时间：2015-1-19 下午06:33:26     
* 修改备注：   
* @version
 */
public class CipherUtil{  
      
    //十六进制下数字到字符的映射数组  
    private final static String[] hexDigits = {"0", "1", "2", "3", "4",  
        "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};  
      
    /**
     * 
    * 方法名: generatePassword
    * 方法作用: TODO 对字符串进行加密
    * 创建人：Jxufe HeHaiYang
    * 创建时间：2015-1-20 下午09:58:05   
    * @param @param inputString
    * @param @return    
    * 返回值类型： String    
    * @throws
     */
    public static String generatePassword(String inputString){  
        return encodeByMD5(inputString);  
    }  
      
    /**
     *  
    * 方法名: validatePassword
    * 方法作用: TODO 验证输入的密码是否正确 
    * 创建人：Jxufe HeHaiYang
    * 创建时间：2015-1-20 下午09:57:52   
    * @param @param password
    * @param @param inputString
    * @param @return    
    * 返回值类型： boolean    
    * @throws
     */
    public static boolean validatePassword(String password, String inputString){  
        if(password.equals(encodeByMD5(inputString))){  
            return true;  
        } else{  
            return false;  
        }  
    }  
    /** 
     * 
    * 方法名: encodeByMD5
    * 方法作用: TODO 对字符串进行MD5加密
    * 创建人：Jxufe HeHaiYang
    * 创建时间：2015-1-20 下午09:57:38   
    * @param @param originString
    * @param @return    
    * 返回值类型： String    
    * @throws
     */
    private static String encodeByMD5(String originString){  
        if (originString != null){  
            try{  
                //创建具有指定算法名称的信息摘要  
                MessageDigest md = MessageDigest.getInstance("MD5");  
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算  
                byte[] results = md.digest(originString.getBytes());  
                //将得到的字节数组变成字符串返回  
                String resultString = byteArrayToHexString(results);  
                return resultString.toUpperCase();  
            } catch(Exception ex){  
                ex.printStackTrace();  
            }  
        }  
        return null;  
    }  
      
    /**  
     * 
    * 方法名: byteArrayToHexString
    * 方法作用: TODO 转换字节数组为十六进制字符串 
    * 创建人：Jxufe HeHaiYang
    * 创建时间：2015-1-20 下午09:57:29   
    * @param @param b
    * @param @return    
    * 返回值类型： String    
    * @throws
     */
    private static String byteArrayToHexString(byte[] b){  
        StringBuffer resultSb = new StringBuffer();  
        for (int i = 0; i < b.length; i++){  
            resultSb.append(byteToHexString(b[i]));  
        }  
        return resultSb.toString();  
    }  
      
    /**
     * 
    * 方法名: byteToHexString
    * 方法作用: TODO 将一个字节转化成十六进制形式的字符串
    * 创建人：Jxufe HeHaiYang
    * 创建时间：2015-1-20 下午09:57:17   
    * @param @param b
    * @param @return    
    * 返回值类型： String    
    * @throws
     */
    private static String byteToHexString(byte b){  
        int n = b;  
        if (n < 0)  
            n = 256 + n;  
        int d1 = n / 16;  
        int d2 = n % 16;  
        return hexDigits[d1] + hexDigits[d2];  
    }  
}  
