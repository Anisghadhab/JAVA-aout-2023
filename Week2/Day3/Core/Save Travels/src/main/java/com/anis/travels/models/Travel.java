package com.anis.travels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


	@Entity
	@Table(name = "travels")
	public class Travel {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@NotNull
		@Size(min = 5, max = 200)
		private String name;
		@NotNull
		@Size(min = 5, max = 200)
		private String vendor;
		@NotNull
		@Min(1)
		private Integer amount;
		@NotNull
		@Size(min = 5, max = 200)
		private String description;
		
		
		// This will not allow the createdAt column to be updated after creation
		@Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;

		// empty constructor
		public Travel() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public String getVendor() {
			return vendor;
		}

		public void setVendor(String vendor) {
			this.vendor = vendor;
		}

		public Integer getAmount() {
			return amount;
		}

		public void setAmount(Integer amount) {
			this.amount = amount;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		
	}
