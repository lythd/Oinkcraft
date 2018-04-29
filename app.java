//Program: Oinkcraft Bot
//Programmer: SpartanSpark
//Date: 13 May 2017

package com.hey.OinkcraftBot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class App extends ListenerAdapter {
	
	public String prefix;
	
	public static void main( String[] args ) throws LoginException, IllegalArgumentException, InterruptedException, RateLimitedException {
		prefix = "^";
		//Initializes the bot
		JDA jdaBot = new JDABuilder(AccountType.BOT).setToken("NDQwMTM0MDQ3MzIzMzg5OTYy.DcdSXw.zHlfIgnzR2v5RbCq6GsJ_-rH2lk").buildBlocking();
		jdaBot.addEventListener(new App());
     
	}
 
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
     
		//Obtains properties of the received message
		Message objMsg = e.getMessage();
		MessageChannel objChannel = e.getChannel();
		User objUser = e.getAuthor();
     
		//Responds to any user who says "hello"
		if (objMsg.getContentRaw().equals("hello")) {
			objChannel.sendMessage("Hello, " + objUser.getAsMention() +"!").queue();
		}
     
	}
}
