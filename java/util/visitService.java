package util;

import Channel.DB.ChannelBean;
import Content.DB.ContentBean;

import java.sql.*;

import static util.dbService.dbConntect;

public class visitService {
	private static int result = 0;

	private static void dbUpdateProcess(String query) {
		try (Connection connect = dbService.ds.getConnection();) {
			Statement statement = connect.createStatement();
			result = statement.executeUpdate(query);
			if (result == 1) {
				System.out.println("방문자 수 1 증가");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static void ContentLikeUp(ContentBean content) { //좋아요 수 증감 메소드
		dbConntect();
		String query = "update chboard set boardheart = " + (content.getBoardHeart() + 1) + " where chnum = " + content.getBoardNum();
		dbUpdateProcess(query);
	}
	
	public static void ContentLikeDown(ContentBean content) { //좋아요 수 증감 메소드
		dbConntect();
		String query = "update chboard set boardheart = " + (content.getBoardHeart() - 1) + " where chnum = " + content.getBoardNum();
		dbUpdateProcess(query);
	}
	
	public static void contentVisitUp(ContentBean content) {
		dbConntect();
		String query = "update chboard set boardvisit = " + content.getBoardVisit() + 1 + " where boardnum = " + content.getBoardNum();
		dbUpdateProcess(query);
	}

	public static void channelVisitUp(ChannelBean channel) {
		dbConntect();
		String query = "update channellist set chvisit = " + channel.getChvisit() + 1 + " where chnum = " + channel.getChnum();
		dbUpdateProcess(query);
	}
}