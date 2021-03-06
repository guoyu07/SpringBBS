package cn.tiger.entity.bbs;
// Generated 2016-5-25 12:13:56 by Hibernate Tools 3.5.0.Final

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.tiger.entity.account.AcctUser;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name = "Comment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Comment implements java.io.Serializable {

	private Long id;
	private Topic topic;
	private String content;
	private Date createTime;
	private int status;
	
	//comment_ad
	private CommentAd commentAd;

	private AcctUser acctuser;

	public Comment() {
	}

	public Comment(Topic topic, String content, Date createTime, int status) {
		this.topic = topic;
		this.content = content;
		this.createTime = createTime;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "topic_id")
	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Column(nullable=false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="create_time")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Transient
	public String createTimeToString(){
		return createTime.toLocaleString();
	}
	
	//处理过时的toLocaleString()
	@Transient
	public String createTimeToString2(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(createTime);
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public AcctUser getAcctuser() {
		return acctuser;
	}

	public void setAcctuser(AcctUser acctuser) {
		this.acctuser = acctuser;
	}
	
	@OneToOne(fetch = FetchType.EAGER,mappedBy="comment")
	public CommentAd getCommentAd() {
		return commentAd;
	}

	public void setCommentAd(CommentAd commentAd) {
		this.commentAd = commentAd;
	}
}
