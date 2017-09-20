package test;

import java.io.*;
import java.util.Scanner;

public class WCmain {
	public static void choice( InputStreamReader isr,int i ) throws IOException{
		int  Cchar;
		int count = 0;
		switch(i){
		case 1:  
			while ((Cchar = isr.read()) != -1) 
			{
				if(Cchar !=' ')
				{
					count++;
				}	
			}
			System.out.println(" 字符数："+count);  break;
		case 2:	
			int flag=' ';
			while ((Cchar = isr.read()) != -1) 
			{
					if(Cchar !=' ' && (flag==' ' || flag=='\n'))
					{
						count++;
					}	
					flag=Cchar;
			}
			System.out.println(" 单词数："+count);  break;
		case 3:
			while ((Cchar = isr.read()) != -1) 
			{
					if(Cchar=='\n')
					{
						count++;
					}	
			}
			System.out.println(" 行数："+(++count));  break;
		case 4:
			System.out.println("递归处理");
			break;
		case 5: 
			 BufferedReader buff=new BufferedReader(isr);
			 AdvOpt(buff);
		}
	}
	
	public static void AdvOpt(BufferedReader buff) throws IOException{
		int code = 0;
        int empty = 0;
        int notes = 0;//初始化三个行数变量
        String stra; 
        while ((stra = buff.readLine())!=null)//读到末尾停止
        {
        	String[] string = stra.split(" ");
        	int n=string.length;
        	if(n==0){
        		empty++;
        		System.out.println(empty);
        	}
        	else{
            if (string[n-1].equals("") || string[n-1].equals("{") || string[n-1].equals("}"))
            { 
                empty++;
            } 
            else if((stra.indexOf("//"))>-1)//判断字符串stra中是否存在//字符
            {
            	notes++;
            }
            else
                code++;
        }
        	}
        System.out.println("空行数为："+empty);
        System.out.println("注释行数为："+notes);
        System.out.println("代码行数为："+code);
	}

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		System.out.println("输入指令和文件位置：");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String str =scan.nextLine();
		String[] strs = str.split(" ");
		int n=strs.length;
		File file = new File(strs[n-1]);
		try {
			FileInputStream fs = new FileInputStream(file);
			  InputStreamReader isr = new InputStreamReader(fs);
	          if(strs[0].equals("-c")){
	        	  choice(isr,1);
	          }
	          else if(strs[0].equals("-w")){
	        	  choice(isr,2);
	          }
	          else if(strs[0].equals("-l")){
	        	  choice(isr,3);
	          }
	          else if(strs[0].equals("-s")){
	        	  choice(isr,4);
	          }
	          else if(strs[0].equals("-a")){
	        	  choice(isr,5);
	          }
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			System.out.println("未找到该文件");
			e.printStackTrace();
		}
		
	}

}
