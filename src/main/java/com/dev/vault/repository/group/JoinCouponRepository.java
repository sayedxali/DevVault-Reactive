package com.dev.vault.repository.group;

import com.dev.vault.model.group.JoinCoupon;
import com.dev.vault.model.group.Project;
import com.dev.vault.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface JoinCouponRepository extends JpaRepository<JoinCoupon, Long> {
    Optional<JoinCoupon> findByProjectAndRequestingUserAndCoupon(Project project, User requestingUser, String coupon);
    Optional<JoinCoupon> findByCoupon(@NonNull String coupon);
    Optional<JoinCoupon> findByRequestingUserAndProject(User requestingUser, Project project);
}