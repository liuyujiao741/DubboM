package com.alibaba.dubbo.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.dubbo.common.ParamObject;
import com.alibaba.dubbo.common.ReturnObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlBeanConvert {
	 
	/**                                                                                                                                                       
	  * java 转换成xml                                                                                                                                           
	  * @Title: toXml                                                                                                                                        
	  * @param obj 对象实例                                                                                                                                        
	  * @return String xml字符�?                                                                                                                                  
	  */                                                                                                                                                        
	 public static String toXml(Object obj){                                                                                                                    
	     XStream xstream=new XStream();                                                                                                                                                       
	     ////如果没有这句，xml中的根元素会�?�?类名>；或者说：注解根本就没生效，�?��的元素名就是类的属�?                                                       
	     //xstream.processAnnotations(obj.getClass()); //通过注解方式的，�?��要有这句�?  
	     xstream.autodetectAnnotations(true);
	     StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r");
	     sb.append(xstream.toXML(obj));
	     return sb.toString();                                                                                                                             
	 }                                                                                                                                                         
	                                                                                                                                                            
	 /**                                                                                                                                                         
	  *  将传入xml文本转换成Java对象                                                                                                                                      
	  * @Title: toBean                                                                                                                                         
	  * @param xmlStr                                                                                                                                           
	  * @param cls  xml对应的class�?                                                                                                                               
	  * @return T   xml对应的class类的实例对象                                                                                                                          
	  *                                                                                                                                                         
	  */                                                                                                                                                        
	 public static <T> T  toBean(String xmlStr,Class<T> cls){                                                                                                  
	     XStream xstream=new XStream();                                                                                                                         
	     xstream.processAnnotations(cls);                                                                                                                       
	     T obj=(T)xstream.fromXML(xmlStr);                                                                                                                      
	     return obj;                                                                                                                                            
	 }  
	 
	 public static ParamObject toParamObject(String xmlStr){                                                                                                  
	     XStream xstream=new XStream();                                                                                                                         
	     xstream.processAnnotations(ParamObject.class);                                                                                                                       
	     ParamObject obj=(ParamObject)xstream.fromXML(xmlStr);                                                                                                                      
	     return obj;                                                                                                                                            
	 }  
	 
	/**
	 * 将传入xml文本转换成ParamObject对象
	 * 
	 * @param xmlStr
	 * @param cls paramInfo对应的class�?
	 * @return
	 */
	public static <T> ParamObject toParamObject(String xmlStr, Class<T> cls){                                                                                                  
	     XStream xstream=new XStream(new DomDriver());                                                                                                                         
	     xstream.processAnnotations(new Class[] {ParamObject.class, cls});                                                                                                                       
	     ParamObject obj=(ParamObject)xstream.fromXML(xmlStr);                                                                                                                      
	     return obj;                                                                                                                                            
	 } 
	
	public static <T> ParamObject toParamObject(String xmlStr, Class<T>[] cls){                                                                                                  
	     XStream xstream=new XStream(new DomDriver());                                                                                                                         
	     xstream.processAnnotations(cls);                                                                                                                       
	     ParamObject obj=(ParamObject)xstream.fromXML(xmlStr);                                                                                                                      
	     return obj;                                                                                                                                            
	 } 
	 
	 public static ReturnObject toReturnObject(String xmlStr){                                                                                                  
	     XStream xstream=new XStream(new DomDriver());                                                                                                                         
	     xstream.processAnnotations(ReturnObject.class);                                                                                                                       
	     ReturnObject obj=(ReturnObject)xstream.fromXML(xmlStr);                                                                                                                      
	     return obj;                                                                                                                                            
	 }  
	 
	 @SuppressWarnings("rawtypes")
	public static ReturnObject toReturnObject(String xmlStr, Class cls){                                                                                                  
	     XStream xstream=new XStream(new DomDriver());                                                                                                                         
	     xstream.processAnnotations(new Class[] {ReturnObject.class, cls});                                                                                                                       
	     ReturnObject obj=(ReturnObject)xstream.fromXML(xmlStr);                                                                                                                      
	     return obj;                                                                                                                                            
	 } 
	 
	 public static <T> ReturnObject toReturnObject(String xmlStr, Class<T>[] cls){
		 XStream xstream=new XStream();                                                                                                                         
	     xstream.processAnnotations(cls);                                                                                                                       
	     ReturnObject obj=(ReturnObject)xstream.fromXML(xmlStr);                                                                                                                      
	     return obj;
	 }
	                                                                                                                                                            
	/**                                                                                                                                                         
	  * 写到xml文件中去                                                                                                                                                 
	  * @Title: writeXMLFile                                                                                                                                    
	  * @param obj 对象                                                                                                                                               
	  * @param absPath 绝对路径                                                                                                                                        
	  * @param fileName  文件�?                                                                                                                                    
	  * @return boolean                                                                                                                                         
	  */                                                                                                                                                       
	 public static boolean toXMLFile(Object obj, String absPath, String fileName ){                                                                            
	     String strXml = toXml(obj);                                                                                                                           
	     String filePath = absPath + fileName;                                                                                                                  
	     File file = new File(filePath);                                                                                                                        
	     if(!file.exists()){                                                                                                                                   
	         try {                                                                                                                                             
	             file.createNewFile();                                                                                                                          
	         } catch (IOException e) {                                                                                                                         
	             return false ;                                                                                                                                 
	         }                                                                                                                                                  
	     }                                                                                                                                                      
	     OutputStream ous = null ;                                                                                                                             
	     try {                                                                                                                                                  
	         ous = new FileOutputStream(file);                                                                                                                  
	         ous.write(strXml.getBytes());                                                                                                                      
	         ous.flush();                                                                                                                                       
	     } catch (Exception e1) {                                                                                                                               
	         return false;                                                                                                                                     
	     }finally{                                                                                                                                             
	         if(ous != null )                                                                                                                                   
	             try {                                                                                                                                          
	                 ous.close();                                                                                                                               
	             } catch (IOException e) {                                                                                                                      
	             }                                                                                                                                             
	     }                                                                                                                                                      
	     return true ;                                                                                                                                          
	 }                                                                                                                                                         
	                                                                                                                                                            
	 /**                                                                                                                                                        
	  * 从xml文件读取报文                                                                                                                                            
	  * @Title: toBeanFromFile                                                                                                                                 
	  * @param absPath 绝对路径                                                                                                                                     
	  * @param fileName 文件�?                                                                                                                                    
	  * @param cls                                                                                                                                              
	  * @throws Exception                                                                                                                                       
	  * @return T                                                                                                                                               
	  */                                                                                                                                                        
	 public static <T> T  toBeanFromFile(String absPath, String fileName,Class<T> cls) throws Exception{                                                        
	     String filePath = absPath +fileName;                                                                                                                   
	     InputStream ins = null ;                                                                                                                               
	     try {                                                                                                                                                  
	         ins = new FileInputStream(new File(filePath ));                                                                                                    
	     } catch (Exception e) {                                                                                                                                
	         throw new Exception("读{"+ filePath +"}文件失败", e);                                                                                               
	     }                                                                                                                                                      
	     XStream xstream=new XStream();                                                                                                                          
	     xstream.processAnnotations(cls);                                                                                                                       
	     T obj =null;                                                                                                                                           
	     try {                                                                                                                                                  
	         obj = (T)xstream.fromXML(ins);                                                                                                                    
	     } catch (Exception e) {                                                                                                                               
	         throw new Exception("解析{"+ filePath +"}文件失败",e);                                                                                              
	     }                                                                                                                                                      
	     if(ins != null)                                                                                                                                        
	         ins.close();                                                                                                                                      
	     return obj;                                                                                                                                            
	 }    
}
