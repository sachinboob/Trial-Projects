package com.trial.demo;

import java.io.File;
import java.io.FileInputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Jsch_Trial {

	public void upload(String filename) {
//		try {
//			JSch jsch = new JSch();
//			Session session = jsch.getSession(", server, port);
//			session.setPassword(password);
//
//			java.util.Properties config = new java.util.Properties();
//			config.put("StrictHostKeyChecking", "no");
//			session.setConfig(config);
//			session.connect();
//
//			Channel channel = session.openChannel("sftp");
//			channel.connect();
//			ChannelSftp channelSftp = (ChannelSftp) channel;
//			channelSftp.cd(workingDirectory);
//			File f = new File(filename);
//
//			channelSftp.put(new FileInputStream(f), f.getName());
//
//			f.delete();
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
	}
}
