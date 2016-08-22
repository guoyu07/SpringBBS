package cn.tiger.entity.bbs;
// Generated 2016-8-10 23:09:16 by Hibernate Tools 3.5.0.Final

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * CommunityLevel generated by hbm2java
 */
@Entity
@Table(name = "community_level")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CommunityLevel implements java.io.Serializable {

	private Long id;
	private long experience;
	private int levels;
	private byte[] img;

	public CommunityLevel() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="experience")
	public long getExperience() {
		return this.experience;
	}

	public void setExperience(long experience) {
		this.experience = experience;
	}

	@Column(name="levels")
	public int getLevels() {
		return this.levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	@Lob 
	@Basic(fetch=FetchType.LAZY) 
	@Column(name="img", columnDefinition="BLOB", nullable=true)
	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

}