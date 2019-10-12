/*
package com.goodhealth.happiness.util;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
*/
/*
 * @ClassName JpaPageHelper
 * @Author WuDengHui
 * @Description  逻辑分页插件，调用静态方法SetStartPage传入需要分页的List集合即可
 * @Date 2019/4/2016:41
 **//*


public class JpaPageHelper {

    public List<PageInfo> SetStartPage(List<?> list, int pageNow, int Size){
        boolean isFristPage=false;
        boolean isLastPage=false;
        boolean haveNexPage=false;
        boolean havePerPage=false;
        int pageSize=0;
        int fromIndex=(pageNow-1)*Size;
        int toIndex=pageNow*Size;
        if(fromIndex==0) {
            isFristPage=true;
        }else if (!isFristPage) {
            havePerPage=true;
        }
        if(toIndex>=list.size()) {
            toIndex=list.size();
            isLastPage=true;
        }else if (!isLastPage) {
            haveNexPage=true;
        }
        if(list.size()%Size==0) {
            pageSize=list.size()/Size;
        }else {
            pageSize=list.size()/Size+1;
        }
        List<PageInfo> pageInfos=new ArrayList<>();
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageNow(pageNow);
        pageInfo.setTotlePage(pageSize);
        pageInfo.setPgaeSize(Size);
        pageInfo.setFristPage(isFristPage);
        pageInfo.setLastPage(isLastPage);
        pageInfo.setHaveNexPage(haveNexPage);
        pageInfo.setHavePerPage(havePerPage);
        pageInfo.setList(list.subList(fromIndex, toIndex));
        pageInfos.add(pageInfo);
        return pageInfos;
    }
}

*/
