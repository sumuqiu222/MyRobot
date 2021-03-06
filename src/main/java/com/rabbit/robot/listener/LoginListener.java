package com.rabbit.robot.listener;

import com.rabbit.robot.constants.CommonConstant;
import com.rabbit.robot.star.RobotStar;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.BotOfflineEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import static com.rabbit.robot.star.RobotStar.myself;

/**
 * @author 邢晨旭
 * @date 2020/10/17 5:58 下午
 * 致终于来到这里的勇敢的人:
 * 永远不要放弃！永远不要对自己失望！永远不要逃走辜负了自己。
 * 永远不要哭啼！永远不要说再见！永远不要说慌来伤害目己。
 */
@Service
public class LoginListener extends SimpleListenerHost {

    @EventHandler
    public void onMessage(BotOfflineEvent event) {
        boolean online = event.getBot().isOnline();
        if (!online) {
            event.getBot().login();
        }
    }

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        /**
         * 异常处理方式
         * 给自己发消息
         */
        myself.sendMessage("群聊消息处理错误!" + exception.getMessage());
    }
}
