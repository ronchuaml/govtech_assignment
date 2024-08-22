INSERT INTO Applicant (id, name, marital_status, employment_status, sex, date_of_birth, created_at, updated_at) VALUES
('01913b7a-4493-74b2-93f8-e684c4ca935c', 'James', 'single' , 'unemployed', 'male', '1990-07-01', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('01913b80-2c04-7f9d-86a4-497ef68cb3a0', 'Mary', 'married' , 'unemployed', 'female', '1984-10-06', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO Household (id, applicant_id, name, relation, employment_status, date_of_birth, created_at, updated_at) VALUES
('01913b88-1d4d-7152-a7ce-75796a2e8ecf', '01913b80-2c04-7f9d-86a4-497ef68cb3a0', 'Gwen', 'daughter', 'unemployed', '2016-02-01', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('01913b88-65c6-7255-820f-9c4dd1e5ce79', '01913b80-2c04-7f9d-86a4-497ef68cb3a0', 'Jayden', 'son', 'unemployed', '2018-03-15', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO Scheme (id, name, description, created_at, updated_at) VALUES
('01913b89-9a43-7163-8757-01cc254783f3', 'Retrenchment Assistance Scheme', 'Assistance scheme for retrenched individuals.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('01913b89-befc-7ae3-bb37-3079aa7f1be0', 'Retrenchment Assistance Scheme (families)', 'Assistance scheme for retrenched individuals with families.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO Benefit (id, scheme_id, name, amount, created_at, updated_at) VALUES
('01913b8b-9b12-7d2c-a1fa-ea613b802ebc', '01913b89-9a43-7163-8757-01cc254783f3', 'SkillsFuture Credits', 500.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO Application (id, applicant_id, scheme_id, status, created_at, updated_at) VALUES
('a1b2c3d4-e5f6-7a8b-9c0d-1e2f3g4h5i6j', '01913b7a-4493-74b2-93f8-e684c4ca935c', '01913b89-9a43-7163-8757-01cc254783f3', 'pending', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO scheme_criteria (id, scheme_id, marital_status, employment_status, has_children, children_min_age, children_max_age, created_at, updated_at) VALUES
('a2b3c4d5-e6f7-8a9b-0c1d-2e3f4g5h6i7j', '01913b89-befc-7ae3-bb37-3079aa7f1be0', NULL, 'unemployed', TRUE, 6, 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);