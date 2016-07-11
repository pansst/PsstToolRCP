package com.psst.tool.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

/** 
 * @author Administrator
 * @Email  syslijian_pst@163.com
 * @version 1.0.0
 * @time 2016年7月11日 下午12:14:13 
 */
public class FileExtChnageBanch {
    private String path;
    private String oldExt;
    private String newExt;
    private boolean copyFlagChange;
    private String regex;
    public FileExtChnageBanch(String path, String oldExt, String newExt) {
        super();
        this.path = path;
        this.oldExt = oldExt;
        this.newExt = newExt;
        this.regex = ".*\\." + oldExt +"$";
        this.copyFlagChange = false;
    }
    public FileExtChnageBanch(String path, String oldExt, String newExt, boolean copyFlagChange) {
        super();
        this.path = path;
        this.oldExt =  oldExt;
        this.newExt =  newExt;
        this.regex = ".*\\." + oldExt +"$";
        this.copyFlagChange = copyFlagChange;
    }
    
    
    public boolean changeExt(){
        try {
            File dir = new File(path);
            if(dir.exists() && dir.isDirectory()) {
                File[] files = dir.listFiles(new FilenameFilter() {
                    Pattern pattern = Pattern.compile(regex);
                    @Override
                    public boolean accept(File dir, String name) {
                        return pattern.matcher(name).matches();
                        //return name.endsWith(oldExt);
                    }
                });
                for(File f : files) {
                    String name =  f.getAbsolutePath();
                    name = name.substring(0,name.lastIndexOf("."));
                    name = name + "." + newExt;
                    if(copyFlagChange) {
                        File newFile  = new File(name);
                        InputStream inputStream = new FileInputStream(f);
                        OutputStream outputStream = new FileOutputStream(newFile);
                        byte[] buffer = new byte[128];
                        int len = 0;
                        while((len = inputStream.read(buffer)) > 0) {
                            outputStream.write(buffer, 0, len);
                        }
                        try {
                            inputStream.close();
                            outputStream.close();
                        } catch (Exception e) {
                        }finally{
                            if(null != inputStream) {
                                inputStream.close();
                            }
                            if(null != outputStream) {
                                outputStream.close();
                            }
                        }
                        
                    } else {
                        f.renameTo(new File(name));
                    }
                }
                return true;
            } 
        } catch (Exception e) {
        }
        return false;
    }
    public static void main(String[] args) {
//        String name = "D:/订单/1.txt";
//        String ext = ".*\\.txt$";
//        Pattern pattern = Pattern.compile(ext);
//        System.out.println(pattern.matcher(name).matches());
        
    }
    
}
