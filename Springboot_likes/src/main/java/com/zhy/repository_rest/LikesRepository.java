
package com.zhy.repository_rest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import com.zhy.model.ArticleLikesRecord;

@RepositoryRestResource(collectionResourceRel = "blog", path = "blog")
public interface LikesRepository extends MongoRepository<ArticleLikesRecord, String> {}
