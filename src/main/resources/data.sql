
--categories
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
  (url_image, title, degree, event_date, event_time, capacity,  highlight, description, category_id)
VALUES
  ('https://i.blogs.es/164b03/curso-programacion/1366_2000.jpg', 'Webinar Buenas Practicas en Desarrollo de Aplicaciones con React', 'Intermediate', '2023-05-20', '09:00', 50, TRUE,
  'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 2);


INSERT
INTO
  events
  (url_image, title, degree, event_date, event_time, capacity,  highlight, description, category_id)
VALUES
  ('https://i.ytimg.com/vi/1xFscRkO8QU/maxresdefault.jpg', 'Workshop de Programacion CNC | CMZ Academy', 'Intermediate', '2023-06-20', '19:00', 30, FALSE,
  'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 1);

INSERT
INTO
  events
  (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
VALUES
  ('https://assets2-programarya-com.juandmegon.com/img/Cursos-Avanzados/Peticiones-HTTP-con-Laravel/icon.png', 'Master Class Desarrollo de Aplicaciones Web Escalables con Node.js y Express','Advanced', '2023-07-15', '08:00', 20, FALSE,
  'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 3);
---
INSERT
INTO
  events
  (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
VALUES
  ('https://databits.ai/wp-content/uploads/2020/02/Miniatura-01.png', '"Master class Introduccion a la Programacion en Python','Beginner', '2023-04-15', '08:30', 50, FALSE,
  'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 3);

INSERT
INTO
  events
  (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
VALUES
  ('https://i.ytimg.com/vi/quq5142QEiA/maxresdefault.jpg', 'Webinar fundamentos de Java','Beginner', '2023-04-01', '08:30', 50, TRUE,
  'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 2);
------
INSERT
INTO
  events
  (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
VALUES
  ('https://tincode-django.s3.amazonaws.com/media/learning_careers/e11ed32a-2ca9-4654-9495-9a0a59abf270.jpg', 'Work Shop Desarrollo de Aplicaciones Moviles con React Native','Intermediate', '2023-05-07', '08:00', 30, FALSE,
  'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 1);

INSERT
INTO
  events
  (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
VALUES
  ('https://assets2-programarya-com.juandmegon.com/img/Cursos-Avanzados/Peticiones-HTTP-con-Laravel/icon.png', 'Master Class Desarrollo de Aplicaciones Web con MEAN Stack','Intermediate', '2023-08-01', '08:00', 30, FALSE,
  'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 3);
------

INSERT
INTO
  events
  (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
VALUES
  ('https://www.nextraining.es/wp-content/uploads/2021/01/MEAN-Stack-MongoDB-Express.js-AngularJS-y-NodeJS.png', 'Work Shop Inteligencia Artificial con TensorFlow','Advanced', '2023-07-04', '09:00', 20, TRUE,
  'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 1);

INSERT
INTO
  events
  (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
VALUES
  ('https://www.gb-advisors.com/wp-content/uploads/2018/10/Seguridad-de-aplicaciones-web-4-2.png', 'Webinar Seguridad en Aplicaciones Web','Advanced', '2023-06-25', '17:00', 20, FALSE,
  'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 2);

  INSERT
  INTO
    events
    (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
  VALUES
    ('https://www.azulweb.net/wp-content/uploads/2020/05/videojuegos-unity-3d-ATCONMASFUTURO17-18-1.png', 'Master Class Desarrollo de Juegos en Unity','Advanced', '2023-07-07', '09:30', 20, TRUE,
    'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 3);

  INSERT
  INTO
    events
    (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
  VALUES
    ('https://i.ytimg.com/vi/5sapd1rsGbs/maxresdefault.jpg', 'Webinar Desarrollo de videojuegos con Unity','Beginner', '2023-06-25', '09:00', 30, TRUE,
    'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 2);

  INSERT
  INTO
    events
    (url_image, title, degree, event_date, event_time, capacity, highlight,description, category_id)
  VALUES
    ('https://factor3d.com/wp-content/uploads/2020/07/La-gu%C3%ADa-definitiva-del-desarrollo-de-videojuegos-con-Unity.jpg', 'Work Shop Desarrollo de videojuegos con Unity','Intermediate', '2023-07-01', '09:00', 30, TRUE,
    'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 1);


---InscribedUsers
INSERT
INTO
  inscribed_users
  (user_id, event_id)
VALUES
  (2, 3);