package com.app.messagingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.messagingservice.entity.OtpEntity;

@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Long>{

	@Query("SELECT o FROM OtpEntity o WHERE o.sapCode = :sapCode and o.uuid =:uuid and o.otpValue =:otp_value and expireTime > CURRENT_TIMESTAMP()")
	OtpEntity findByUserId(@Param("sapCode") String sapCode, @Param("uuid") String uuid, @Param("otp_value") int otp_value);

}
