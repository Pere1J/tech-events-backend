


INSERT
INTO
  categories
  (name)
VALUES
  ('Workshop');

INSERT
INTO
    categories
    (name)
VALUES
    ('Webinar');
INSERT
INTO
      categories
      (name)
VALUES
      ('Masterclass');

--events -------

INSERT
INTO
  events
  (url_image, title, nivel, fecha, hora, capacity,  highlight, active,description, category_id)
VALUES
  ('https://www.digitallearning.es/wp-content/uploads/2017/11/PosterCurso_IniciacionProgamacionJS.png', 'Taller de iniciación a la programación', 'Beginner', '2023-05-20', '09:00', 20, TRUE, TRUE,'Si usas herramientas informáticas, quizás te hayas planteado en alguna ocasión aprender a programar para poder abordar nuevos proyectos, mejorar tus competencias profesionales o simplemente como hobby.Si usas herramientas informáticas, quizás te hayas planteado en alguna ocasión aprender a programar para poder abordar nuevos proyectos, mejorar tus competencias profesionales o simplemente como hobby.Si usas herramientas informáticas, quizás te hayas planteado en alguna ocasión aprender a programar para poder abordar nuevos proyectos, mejorar tus competencias profesionales o simplemente como hobby.', 2);


INSERT
INTO
  events
  (url_image, title, nivel, fecha, hora, capacity,  highlight, active,description, category_id)
VALUES
  ('https://i.ytimg.com/vi/1xFscRkO8QU/maxresdefault.jpg', 'Curso Intermedio Programación CNC | CMZ Academy', 'Intermediate', '2023-06-20', '19:00', 10, TRUE, TRUE,'Curso CNC orientado a personas con experiencia en el manejo de tornos control numérico pero que desean aprender o aumentar sus conocimientos con la herramien...', 3);

INSERT
INTO
  events
  (url_image, title, nivel, fecha, hora, capacity, highlight, active,description, category_id)
VALUES
  ('https://i.ytimg.com/vi/1xFscRkO8QU/maxresdefault.jpg', 'Curso Avanzado de Programación','Advanced', '2023-05-01', '08:00', 100, TRUE, TRUE,'This course teaches additional skills and techniques to programmers who can already write comprehensive RPG IV programs.                       This class offers a comprehensive discussion of some of the advanced features and functions of RPG IV. This class is designed to enable an experienced RPG IV programmer to develop and maintain RPG IV programs of an advanced level using the latest features and techniques available in the IBM i RPG IV compiler.', 1);

