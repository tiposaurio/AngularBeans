/*
 * AngularBeans, CDI-AngularJS bridge 
 *
 * Copyright (c) 2014, Bessem Hmidi. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 */

/**
 @author Bessem Hmidi
 */
package angularBeans.log;

import java.io.Serializable;
import java.util.LinkedList;

import angularBeans.context.NGSessionScoped;

@NGSessionScoped
public class NGLogger implements Serializable {

	public enum Level {
		LOG("log"), INFO("info"), WARN("warn"), ERROR("error"), DEBUG("debug");

		private String level;

		private Level(String level) {
			this.level = level;
		}

		public String getLevel() {
			return level;
		}
	}

	private LinkedList<LogMessage> logPool = new LinkedList<LogMessage>();

	// private String UID;
	//
	// public void setUID(String uID) {
	// UID = uID;
	// }

	public void log(Level level, String message,Object... args) {
		// LinkedList<LogMessage> logPool=locator.getLogPool(UID);
		logPool.addLast(new LogMessage(level.getLevel(),String.format(message, args) ));

	}

	public LogMessage poll(String UID) {
		// LinkedList<LogMessage> logPool=locator.getLogPool(UID);
		return logPool.pollFirst();
	}

	public LinkedList<LogMessage> getLogPool() {
		// LinkedList<LogMessage> logPool=locator.getLogPool(UID);
		return logPool;
	}

}
