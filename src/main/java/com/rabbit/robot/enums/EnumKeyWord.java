package com.rabbit.robot.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 邢晨旭
 * @date 2020/4/4 上午2:20
 */
@Slf4j
public enum EnumKeyWord {
    /**
     * 查询?双梦?踏云
     */
//    GROUP_SELECT(1,2,"查询"),
//    GROUP_LOVE(1,3,"夸"),
//    GROUP_FUCK(1,4,"骂人"),
    GROUP_SOUP(1, 2,false, "鸡汤"),

    /**
     * 开团？团队标题
     */
    GROUP_KAITUAN(1, 1,false, "开团"),
    GROUP_KAITUAN_TEST(1, 1,false, "开团测试"),
    GROUP_UPDATE_TUAN(1, 1,false, "修改团名"),
    GROUP_CANCEL_KAITUAN(1, 2,false, "取消开团"),
    GROUP_SEE_KAITUAN(1, 2,false, "查看团队"),
    KAI_ZU_LA(1, 2,false, "开组了报名进组"),
    /**
     * 报名？职业？角色名？位置
     */
    GROUP_BAOMING(1, 1,false, "报名"),
    GROUP_BAOMING2(1, 1,false, "插队"),
    /**
     * 取消报名？位置
     */
    GROUP_CANCEL_BAOMING(1, 2,false, "取消报名"),
    GROUP_CANCEL_BAOMING2(1, 1,false, "取消插队"),
    TEAM_AUTHORITY(1, 2,false, "开团功能"),
    OTHER_AUTHORITY_OPEN(1, 2,false, "启动兔砸"),
    OTHER_AUTHORITY_CLOSE(1, 2,false, "关闭兔砸"),
    /**
     * 日常
     */
    RI_CHANG(1, 2,false, "日常"),
    PEI_ZHUANG(1, 1,false, "配装"),
    MACRO(1, 1,false, "宏"),
    XIAO_YAO(1, 1,false, "小药"),
    KAI_FU(1, 1,false, "开服"),
    ADORNMENT(1, 1,false, "装饰"),
    HUA_JIA(1, 1,false, "花价"),
    SAO_HUA(1, 2,false, "骚话"),
    TIAN_GOU(1, 2,false, "舔狗语录"),
    EXAM(1, 1,false, "科举"),
    EXAM2(1, 1,false, "kj"),
    TEST(1, 2,false, "测试输出"),


    PRIVATE_DEFAULT(3, 1,false, ""),
    ROBOT_MENU(3, 3,false, ""),
    ;

    /**
     * 类型
     * 1\群聊 2\私聊
     */
    public Integer type;
    /**
     * 关键码
     */
    public Integer code;
    public Boolean CD;
    /**
     * 关键词
     */
    public String keyWord;

    EnumKeyWord(Integer type, Integer code,Boolean cd, String keyWord) {
        this.type = type;
        this.code = code;
        this.CD = cd;
        this.keyWord = keyWord;
    }

    /**
     * 群聊关键词匹配
     *
     * @param keyWord
     * @return
     */
    public static EnumKeyWord groupFind(String keyWord) {

        List<EnumKeyWord> collect = Arrays.stream(EnumKeyWord.values()).filter(e -> e.type.equals(1)).collect(Collectors.toList());
        for (EnumKeyWord value : collect) {
            if (keyWord.equals(value.keyWord)) {
                log.info("群聊关键词匹配->{}", value);
                return value;
            }
        }
        return null;
    }

    /**
     * 私聊关键词匹配
     *
     * @param keyWord
     * @return
     */
    public static EnumKeyWord privateFind(String keyWord) {

        List<EnumKeyWord> collect = Arrays.stream(EnumKeyWord.values()).filter(e -> e.type.equals(2)).collect(Collectors.toList());
        for (EnumKeyWord value : collect) {
            if (keyWord.matches(value.keyWord + ".*"))
                return value;
        }
        return EnumKeyWord.PRIVATE_DEFAULT;
    }
}
