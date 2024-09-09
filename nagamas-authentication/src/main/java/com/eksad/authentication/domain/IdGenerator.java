package com.eksad.authentication.domain.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class IdGenerator implements IdentifierGenerator {

	private static final String QUERY_CALL_STORE_PROC = "select get_seq from \"public\".get_seq()";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
		final String[] result = {null};
		session.doWork(connection -> {
			try (CallableStatement callableStmt = connection.prepareCall(QUERY_CALL_STORE_PROC)) {
				ResultSet rs = callableStmt.executeQuery();
				if (rs.next()) {
					result[0] = rs.getString(1);
				}
			} catch (SQLException e) {
				throw new HibernateException(e);
			}
		});
		return result[0];
	}
}
