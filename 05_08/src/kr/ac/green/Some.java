package kr.ac.green;

import java.util.Scanner;

/*
 * ctrl + d : �ٻ���
 * ctrl + shift + o : �ڵ�����Ʈ
 * alt + shift + s -> c : �⺻������
 * alt + shift + s -> o : �Ķ���� ó�� ������
 * alt + shift + s -> r : getter / setter ����
 * alt + shift + s -> s : toString ����
 * ctrl + shift + f : �ڵ��ٸ���
 * alt + shift + t -> n : rename
 * ctrl + f6 : ����Ʈâ ����
 */
public class Some {
	public String str2 = "zzz";
	String str = "abc";
	private int num;
	private String title;
	private boolean ok;
	private Scanner scan;

	public Some() {
		super();
	}

	public Some(int num, String title, boolean ok) {
		super();
		this.num = num;
		this.title = title;
		this.ok = ok;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	@Override
	public String toString() {
		return "Some [num=" + num + ", title=" + title + ", ok=" + ok + "]";
	}

}
