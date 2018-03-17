package com.example.sasham.passwordkeeper.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import java.util.Date;

/**
 * Created by Sasha M on 15.03.2018.
 */

@Entity(nameInDb = "passwords", active = true)
public class Password {

    @Id
    private Long id;

    @NotNull
    private String title;

    private String email;

    @NotNull
    private String key;

    private String description;

    @NotNull
    private Date date;

//    hash = 943856241
    @Keep
    public Password(Long mId, @NotNull String title, String email, @NotNull String key,
                    String description, @NotNull Date date) {
        this.id = mId;
        this.title = title;
        this.email = email;
        this.key = key;
        this.description = description;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date mDate) {
        this.date = mDate;
    }

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1189424892)
    private transient PasswordDao myDao;


    @Generated(hash = 565943725)
    public Password() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long mId) {
        this.id = mId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String mTitle) {
        this.title = mTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mEmail) {
        this.email = mEmail;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String mKey) {
        this.key = mKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String mDescription) {
        this.description = mDescription;
    }

    @Override
    public String toString() {
        return "Password{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", key='" + key + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 175960626)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPasswordDao() : null;
    }
}
