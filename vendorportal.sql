INSERT INTO `config` (`id`, `email`, `logpath`, `maximopath`, `password`, `passwordmaximo`, `usermaximo`, `header_maximo`, `organization`) VALUES
(1, 'hamza.abidi1@esprit.tn', 'C:/Users/ASUS/Desktop/VendorPortalFront/vendorportal/logs/vendorportal.log', 'http://maxgps.smartech-tn.com:9875', '193JMT0786', 'maxadmin123', 'maxadmin', 'bWF4YWRtaW46bWF4YWRtaW4xMjM=', 'EAGLENA');


INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_FOURNISSEUR'),
(3, 'ROLE_ADMIN');


INSERT INTO `users` (`id`, `address`, `city`, `companywebsite`, `country`, `date_established`, `email`, `firstname`, `is_admin`, `is_enabled`, `is_vendor`, `lastname`, `password`, `phone`, `postalcode`, `region`, `reset_password_token`, `revenu`, `status`, `taxclassificationcode`, `taxregistrationnumber`, `username`, `verify_account_token`, `date_creation`, `langue`) VALUES
(12, NULL, NULL, NULL, NULL, NULL, 'labidihamza099@gmail.com', NULL, b'1', b'1', b'0', NULL, '$2a$10$6MyvXX3cBpraFJe8Ej1tBems1E3PEhyVL1Rj7B9w8.RVy.xT/pShi', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'maxadmin', 'pkytczOs6xfCW4JgcYk1OCuBgJGVjL', NULL, NULL);



INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(12, 3);



