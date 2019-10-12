package com.goodhealth.comm.util.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @Description 导入 Excel 时使用的映射实体类，Excel 模型
 */
public class ImportInfo extends BaseRowModel {
    @ExcelProperty(value = "分类" ,index = 0)
    private String classificationTitle;

    @ExcelProperty(value = "分类id",index = 1)
    private Integer classificationId;

    @ExcelProperty(value = "问题",index = 2)
    private String question;

    @ExcelProperty(value = "答案",index = 3)
    private String answer;

    @ExcelProperty(value = "备用字段",index = 4)
    private String future;

    @ExcelProperty(value = "创建时间",index = 5)
    private String createTime;

    @ExcelProperty(value = "最后修改时间",index = 6)
    private String modifyTime;

    public String getClassificationTitle() {
        return classificationTitle;
    }

    public void setClassificationTitle(String classificationTitle) {
        this.classificationTitle = classificationTitle;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "ImportInfo{" +
                "classificationTitle='" + classificationTitle + '\'' +
                ", classificationId=" + classificationId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", future='" + future + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
