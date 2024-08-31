package org.seunga.User.domain;

import org.seunga.common.domain.PositiveIntegerCounter;

import java.util.Objects;

public class User {
    private final Long id;
    private  final  UserInfo userInfo; // name, profileURL
    private final PositiveIntegerCounter followingCount; // count
    private final PositiveIntegerCounter followerCounter; // count

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.userInfo = userInfo;
        this.followerCounter = new PositiveIntegerCounter();
        this.followingCount = new PositiveIntegerCounter();
    }

    public void follow(User targetUser){
        if(targetUser.equals(this)){
            throw new IllegalArgumentException();
        }
        followingCount.increase();
        //targetUser.followingCount.increase();
        // 친구와만 대화하라
        targetUser.increaseFollowerCount();
    }

    public void unfollow(User targetUser){
        if(targetUser.equals(this)){
            throw new IllegalArgumentException();
        }
        followingCount.decrease();
        //targetUser.followingCount.decrease();
        targetUser.decreaseFollowerCount();
    }

    private void increaseFollowerCount(){
        followerCounter.increase();
    }

    private void decreaseFollowerCount(){
        followerCounter.decrease();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    // 유효성 검사




}
