/*
package com.Jobportal.demo.Service.Impl;

import com.Jobportal.demo.Model.SessionIds;
import com.Jobportal.demo.Repository.SessionTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class SessionToken implements SessionTokenRepository {

    @Autowired
    SessionTokenRepository iSessionToken;

    @Override
    public List<SessionIds> findAll() {
        return null;
    }

    @Override
    public List<SessionIds> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SessionIds> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SessionIds> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(SessionIds sessionIds) {

    }

    @Override
    public void deleteAll(Iterable<? extends SessionIds> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends SessionIds> S save(S s) {
        return null;
    }

    @Override
    public <S extends SessionIds> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<SessionIds> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends SessionIds> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<SessionIds> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SessionIds getOne(String s) {
        return null;
    }

    @Override
    public <S extends SessionIds> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SessionIds> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SessionIds> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SessionIds> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SessionIds> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SessionIds> boolean exists(Example<S> example) {
        return false;
    }

 */
/*@Autowired
    RedisTemplate redisTemplate;

    public boolean saveSessionToken(String token, String username) {

        String KEY = "user";

            try {
              //  Map userHash = new ObjectMapper().convertValue(user, Map.class);
                redisTemplate.opsForHash().put(KEY, token, username);

                return true;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
*//*

}

*/
