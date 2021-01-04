CREATE TABLE Empl_Proj
(
    employee_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,

    CONSTRAINT empl_proj_employee_id FOREIGN KEY (employee_id)
        REFERENCES Employee (id),

    CONSTRAINT empl_proj_project_id FOREIGN KEY (project_id)
        REFERENCES Project (id)
);