package com.zjl.lottery.doubleball.random;

import java.io.File;

public class Test2 {
	public static void main(String[] args) {
		/*for(int z = 0;z < 10;z++){
			for(int y = 0;y < 10;y++){
				for(int x = 0;x < 10;x++){
					for(int w = 0;w < 10;w++){
						for(int v = 0;v < 10;v++){
							for(int u = 0;u < 10;u++){
								for(int t = 0;t < 10;t++){}
							}
						}
						
					}
				}
			}
		}*/
	

		for(int s = 0;s < 10;s++){
			for(int r = 0;r < 10;r++){
				for(int q = 0;q < 10;q++){
					for(int p = 0;p < 10;p++){}
				}
			}
		}
	

		for(int o = 0;o < 10;o++){
			
		}
		
		for(int n = 0;n < 10;n++){
			for(int m = 0;m < 10;m++){
				for(int l = 0;l < 10;l++){
					for(int k = 0;k < 10;k++){
						for(int j = 0;j < 10;j++){
							String basepath = "E:"+
						//File.separator+z+File.separator+y+File.separator+x+File.separator+w+File.separator+v+File.separator+u+File.separator+t+
						//File.separator+s+File.separator+r+File.separator+q+File.separator+p+
						//File.separator+o+
						File.separator+n+File.separator+m+File.separator+l+File.separator+k+File.separator+j;
							for(int i = 0;i < 10;i++){
								String filepath = basepath+File.separator + i;
								File file = new File(filepath);
								if(!file.exists()){
									file.mkdirs();
								}
							}
						}
					}
				}
			}
		}
	
		
		
	}
}
