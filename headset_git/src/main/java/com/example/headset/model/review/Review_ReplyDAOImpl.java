package com.example.headset.model.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Review_ReplyDAOImpl implements Review_ReplyDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Review_ReplyDTO> list(int r_idx, int start, int end) {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("r_idx", r_idx);
		List<Review_ReplyDTO> items = sqlSession.selectList("review_reply.list", map);
		return items;
	}

	@Override
	public int count(int r_idx) {
		return sqlSession.selectOne("review_reply.count", r_idx);
	}

	@Override
	public void insert(Review_ReplyDTO dto) {
		sqlSession.insert("review_reply.insert", dto);
	}

	@Override
	public void update(Review_ReplyDTO dto) {
		sqlSession.update("review_reply.update",dto);
	}

	@Override
	public void delete(int rre_idx) {
		sqlSession.delete("review_reply.delete",rre_idx);
	}

	@Override
	public Review_ReplyDTO detail(int rre_idx) {
		return sqlSession.selectOne("reply.detail", rre_idx);
	}

}
