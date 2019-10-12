/**
 * 
 */
package com.goodhealth.design.demo.CombinatorialPattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description  组合模式 构造一个简单的公司组织图
 *                                         总经理 马三
 *                                         
 *                                         
 *             研发部经理 李斯                 商业部经理  范曲                 人事部经理   杜鹃
 *             
 *             
 *     研发部部员  何一        商业部部员 成将    商业部部员  杜迪     人事部部员   刘原
 * 
 * 
 * 
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//遍历这个图
	public static  void  display(Composite node){
		
		for (Node no :node.getSubordinates()) {
			if (no instanceof Leaf) {
				no.introduction();
			}else{
				no.introduction();
				display((Composite) no);
			}
			
		}
	}
	

}
