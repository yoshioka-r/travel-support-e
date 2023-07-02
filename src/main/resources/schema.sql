-- テーブル削除
DROP TABLE IF EXISTS spots;
DROP TABLE IF EXISTS prefs;
DROP TABLE IF EXISTS inns;
DROP TABLE IF EXISTS inns_detail;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS bokkings;
DROP TABLE IF EXISTS plans;
DROP TABLE IF EXISTS links;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS spots_details;
DROP TABLE IF EXISTS spot_image;

-- spots Table
CREATE TABLE spots
(
   id SERIAL PRIMARY KEY,
   pref_id INTEGER,
   img TEXT,
   name TEXT,
   location TEXT,
   outline TEXT
);

-- Prefs Table
CREATE TABLE prefs
(
   id SERIAL PRIMARY KEY,
   name TEXT
);

-- Inns Table
CREATE TABLE inns
(
   id SERIAL PRIMARY KEY,
   spot_id INTEGER,
   img TEXT,
   name TEXT,
   outline TEXT
  );
  
 --Inns_detail
 CREATE TABLE inns_detail
 (
   id SERIAL PRIMARY KEY,
   inns_id INTEGER,
   location TEXT,
   access TEXT,
   type TEXT,
   meal TEXT,
   price INTEGER
);

-- ユーザーテーブル
CREATE TABLE users
(
  id SERIAL PRIMARY KEY,
  name TEXT,
  address TEXT,
  tel TEXT,
  email TEXT, 
  password TEXT 
);

-- Bookingsテーブル
CREATE TABLE bokkings
(
  id SERIAL PRIMARY KEY,
  inn_id INTEGER,
  plan_id INTEGER,
  stay_date DATE,
  people INTEGER
);

-- Plansテーブル
CREATE TABLE plans
(
  id SERIAL PRIMARY KEY,
  plan TEXT
); 

-- Linksテーブル??
CREATE TABLE links
(
  id SERIAL PRIMARY KEY,
  spot_id INTEGER,
  link TEXT
); 

-- Restaurantsテーブル
CREATE TABLE restaurants
(
  id SERIAL PRIMARY KEY,
  spot_id INTEGER,
  img TEXT,
  name TEXT,
  outline TEXT
); 

-- Spots_detailテーブル
CREATE TABLE spots_details
(
  id SERIAL PRIMARY KEY,
  spot_id INTEGER,
  name TEXT,
  location TEXT,
  access TEXT,
  price INTEGER
); 

-- Spot_imageテーブル??
CREATE TABLE spot_image
(
  id SERIAL PRIMARY KEY,
  spot_id INTEGER,
  img TEXT
); 
