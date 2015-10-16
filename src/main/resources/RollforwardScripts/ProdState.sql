DROP TABLE activities;

CREATE TABLE activities
(
  internal_id bigserial NOT NULL,
  title character varying(255),
  year_level character varying(255),
  capability character varying(1000),
  topic character varying(1000),
  brief_description text,
  description text,
  content_id character varying(1000),
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  skill_description text,
  useful_terms text,
  ac_code character varying(255),
  game_id bigint,
  updated_by bigint
));


DROP TABLE activities_audit;

CREATE TABLE activities_audit
(
  internal_id bigserial NOT NULL,
  activities_id bigint,
  audit_action character varying(255),
  created_by character varying(255),
  activity_date timestamp without time zone,
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  updated_by bigint
);


DROP TABLE activity_item;

CREATE TABLE activity_item
(
  internal_id bigserial NOT NULL,
  activities_id bigint,
  acitivity_type character varying(255),
  acitivity_tips text,
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  updated_by bigint
));


DROP TABLE everyday_idea;

CREATE TABLE everyday_idea
(
  internal_id bigserial NOT NULL,
  title character varying(255),
  year_level character varying(255),
  capability character varying(1000),
  topic character varying(1000),
  brief_description text,
  description text,
  image_id bigint,
  content_id character varying(1000),
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  item_content text,
  updated_by bigint
);


DROP TABLE everyday_idea_audit;

CREATE TABLE everyday_idea_audit
(
  internal_id bigserial NOT NULL,
  everyday_idea_id bigint,
  audit_action character varying(255),
  created_by character varying(255),
  activity_date timestamp without time zone,
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  updated_by bigint
);


DROP TABLE games;

CREATE TABLE games
(
  internal_id bigserial NOT NULL,
  title character varying(255),
  year_level character varying(255),
  capability character varying(1000),
  brief_description text,
  description text,
  image_id bigint,
  content_id character varying(1000),
  resource_id character varying(1000),
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  skill_description text,
  useful_terms text,
  updated_by bigint
);



DROP TABLE games_audit;

CREATE TABLE games_audit
(
  internal_id bigserial NOT NULL,
  games_id bigint,
  audit_action character varying(255),
  created_by character varying(255),
  activity_date timestamp without time zone,
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  updated_by bigint
);


DROP TABLE item_statistics;

CREATE TABLE item_statistics
(
  internal_id bigserial NOT NULL,
  activities_id bigint,
  acitivity_type character varying(255),
  acitivity_action character varying(255),
  activity_date timestamp without time zone,
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  updated_by bigint
);


DROP TABLE parent_image;

CREATE TABLE parent_image
(
  internal_id bigserial NOT NULL,
  image_location_type character varying(255),
  filename character varying(255),
  image_url character varying(1000),
  created_date timestamp without time zone,
  updated_date timestamp without time zone,
  type character varying(100),
  updated_by bigint
);



