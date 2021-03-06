package com.rakovets.course.datapersistence.dao.practice.dao;

import com.rakovets.course.datapersistence.dao.practice.connection.ConnectionManager;
import com.rakovets.course.datapersistence.dao.practice.entity.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReviewDao {
    private static final Object LOCK = new Object();
    private static ReviewDao INSTANCE = null;

    public static ReviewDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ReviewDao();
                }
            }
        }
        return INSTANCE;
    }

    public void save(Review review) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO reviews (text, restaurant_id) VALUES (?, ?);")) {
                preparedStatement.setString(1, review.getText());
                preparedStatement.setLong(2, review.getRestaurant().getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
